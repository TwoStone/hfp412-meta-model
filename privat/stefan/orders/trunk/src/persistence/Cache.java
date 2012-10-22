package persistence;

import java.util.Hashtable;
import modelServer.ServerReporter;

public class Cache {

	protected static final long GarbageCollectorReportInterval = 60000;
		
	private static final long HeapSpaceAllocatable = Runtime.getRuntime().maxMemory();
	private static final long HeapSpaceReserve = HeapSpaceAllocatable / 8;

	private long heapSpaceFree;

	private static Cache theCache = null;

		
	public static Cache getTheCache() {
		if (theCache == null) theCache = new Cache();
		return theCache;
	}

	private Hashtable<Long, Hashtable<Long, PersistentInCacheProxi>> classMap;
	private Hashtable<Integer,String> number2NameMap;
	
	private static ServerReporter reporter; 
	public static void setReporter(ServerReporter theReporter){
		reporter = theReporter;
	}

	private Thread garbageCollector;
	Object lock = new Object();
	int size = 0;
	
	private Cache() {
		this.heapSpaceFree = Long.MAX_VALUE;
		this.classMap = new Hashtable<Long, Hashtable<Long, PersistentInCacheProxi>>();
		this.initializeNumber2NameMap();
		this.garbageCollector = new Thread(new Runnable(){

			public void run() {
				while (!garbageCollector.isInterrupted()){
					synchronized(lock){try {lock.wait(GarbageCollectorReportInterval);} catch (InterruptedException e) {}}//Do nothing and terminate!
					reporter.reportCurrentCacheSize(size);
					if (Cache.this.heapSpaceFree < HeapSpaceReserve){
						Cache.this.heapSpaceFree = Long.MAX_VALUE;
						Object[] classes = classMap.keySet().toArray();
						for (int i = 0; i < classes.length; i++){
							long currentKey = (Long) classes[i];
							if (currentKey > 0){
								Hashtable<Long, PersistentInCacheProxi> objectMap = classMap.get(classes[i]);
								Object[] objects = objectMap.keySet().toArray();
								for (int j = 0; j < objects.length; j++){
									PersistentInCacheProxi current = objectMap.get(objects[j]);
									if (current != null) current.tryBreak();
								}
							}
						}
						System.gc();
					}
				}
			}
		},"Cache Garbage Collector");
		this.garbageCollector.setPriority(Thread.MAX_PRIORITY);
		this.garbageCollector.start();
	}

//	public void reset$For$Test(){
//		this.garbageCollector.interrupt();
//		Cache.theCache = null;
//	}

	public void finalize(){
		this.garbageCollector.interrupt();
	}

	public boolean contains(long objectId, long classId){
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		objectMap = this.classMap.get(new Long(classId));
		if (objectMap == null) return false;
		PersistentInCacheProxi object;
		object = objectMap.get(new Long(objectId));
		return object != null;
	}

	
	public PersistentInCacheProxi get(PersistentProxi proxi)
			throws PersistenceException {
		PersistentInCacheProxi object;
		Long classKey = new Long(proxi.getClassId());
		Long objectKey = new Long(proxi.getId());
		if(objectKey < 0)objectKey = objectKey * -1;
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized(this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		synchronized (objectMap){
			object = objectMap.get(objectKey);
			if (object == null) {
				object = PersistentInCacheProxi.createInCacheProxi(objectKey, proxi.getClassId());
				objectMap.put(objectKey, object);
				size++;
				this.tryTriggerGC();
			}
		}
		return object;
	}
	private void tryTriggerGC(){
		synchronized(lock){
//			long heapSpaceAllocated = Runtime.getRuntime().totalMemory();
//			long unusedHeapSpace = HeapSpaceAllocatable - heapSpaceAllocated;
//			long freeInAllocatedHeapSpace = Runtime.getRuntime().freeMemory();
//			this.heapSpaceFree = freeInAllocatedHeapSpace + unusedHeapSpace;

			this.heapSpaceFree = Runtime.getRuntime().freeMemory() + (HeapSpaceAllocatable - Runtime.getRuntime().totalMemory());
			
			if (this.heapSpaceFree < HeapSpaceReserve) lock.notify();
		}
	}
	public synchronized PersistentInCacheProxi put(PersistentObject object)
			throws PersistenceException {
		Long classKey = new Long(object.getClassId());
		Long objectKey = new Long(object.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized (this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		PersistentInCacheProxi inCache;
		synchronized (objectMap){
			if (objectMap.containsKey(objectKey)) {
				inCache = objectMap.get(objectKey);
			} else {
				inCache = PersistentInCacheProxi.createInCacheProxi(object.getId(),object.getClassId());
				objectMap.put(objectKey, inCache);
				size++;
			}
		}
		inCache.setObject(object);
		this.tryTriggerGC();
		return inCache;
	}
	
	/** Used in fake mode only
	*/
	protected PersistentInCacheProxi putSingleton(PersistentObject candidate) throws PersistenceException{
		PersistentInCacheProxi incache;
		Long classKey = new Long(candidate.getClassId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized (this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		synchronized (objectMap) {
			if (objectMap.size() == 0)return this.put(candidate);
			incache = objectMap.values().iterator().next();			
		}
		if (incache.getTheObject() != null)return incache;
		incache.setObject(candidate);
		return incache;
	}
	/** Used in fake mode only
	*/
	protected java.util.Iterator<PersistentInCacheProxi> iterator(long classNo){
		Long classKey = new Long(classNo);
		Hashtable<Long, PersistentInCacheProxi> objectMap = this.classMap.get(classKey);
		if (objectMap == null) {
			objectMap = new Hashtable<Long, PersistentInCacheProxi>();
			this.classMap.put(classKey, objectMap);
		}
		return objectMap.values().iterator();		
	}

	protected void release(PersistentProxi object) throws PersistenceException  {
		PersistentInCacheProxi objectInCache;
		Long classKey = new Long(object.getClassId());
		Long objectKey = new Long(object.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		objectMap = this.classMap.get(classKey);
		if (objectMap == null)return;
		objectInCache = (PersistentInCacheProxi) objectMap.get(objectKey);
		if (objectInCache == null)return;
		objectInCache.clear();
	}
	public void remove(PersistentInCacheProxi proxi) {
		Long classId = new Long(proxi.getClassId());
		Long objectId = new Long(proxi.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap = this.classMap.get(classId);
		objectMap.remove(objectId);
		synchronized (lock) {
			size--;
		}
	}
	
/* ********************* Cache report ********************** */	

	public String getChacheReport(){
		return this.getCacheInfo().toString();
	}
	private CacheReport getCacheInfo() {
		CacheReport result = new CacheReport();
		for (Long current : this.classMap.keySet()) {
			result.addEntry(this.number2NameMap.get((int)current.longValue()),this.classMap.get(current).size());
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public java.util.Vector getCacheReportList(){
		return new java.util.Vector(getCacheInfo().show());
	}
	class CacheReport {
		class CacheReportEntry implements Comparable<CacheReportEntry>{
			final String typeName;
			final int numberOfObjects;
			CacheReportEntry(String typeName, int numberOfObjects){
				this.typeName = typeName;
				this.numberOfObjects = numberOfObjects;
			}
			public int compareTo(CacheReportEntry o) {
				int result = new Integer(o.numberOfObjects).compareTo(this.numberOfObjects);
				if (result == 0) result = o.typeName.compareTo(this.typeName);
				return result;
			}
			public String toString(){
				return this.typeName + ": " + this.numberOfObjects;
			}
		}
		java.util.TreeSet<CacheReportEntry> data = new java.util.TreeSet<CacheReportEntry>();
		public void addEntry(String typeName, int numberOfObjects) {
			this.data.add(new CacheReportEntry(typeName, numberOfObjects));
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public java.util.Vector show(){
			java.util.Vector result = new java.util.Vector();
			for (CacheReportEntry current : this.data) {
				result.add(current);
			}
			return result;
		}
		public String toString(){
			StringBuffer result = new StringBuffer();
			for (CacheReportEntry current : this.data) {
				result.append(current.toString() + "\n");
			}
			return result.toString();
		}
		
	}
	
	private void initializeNumber2NameMap() {
		this.number2NameMap = new Hashtable<Integer,String>();
		this.number2NameMap.put(107, "Actor");
		this.number2NameMap.put(102, "ActorManager");
		this.number2NameMap.put(105, "AddRoleCommand");
		this.number2NameMap.put(-106, "CommandCoordinator");
		this.number2NameMap.put(-103, "CommandExecuter");
		this.number2NameMap.put(108, "CommonDate");
		this.number2NameMap.put(110, "CreateActorCommand");
		this.number2NameMap.put(101, "Customer");
		this.number2NameMap.put(-111, "ErrorDisplay");
		this.number2NameMap.put(-112, "Server");
		this.number2NameMap.put(104, "Supplier");	
	}
	
}
