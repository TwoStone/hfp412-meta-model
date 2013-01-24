package persistence;



public class QuantifObjectFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public QuantifObjectFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 115)) return 115;
        if(Cache.getTheCache().contains(objectId, 181)) return 181;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void objectSet(long QuantifObjectId, PersistentInstanceObject objectVal) throws PersistenceException {
        
    }
    public void ThisSet(long QuantifObjectId, PersistentQuantifObject ThisVal) throws PersistenceException {
        
    }
    public QuantifObjectSearchList inverseGetObject(long objectId, long classId)throws PersistenceException{
        QuantifObjectSearchList result = new QuantifObjectSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(115);
        while (candidates.hasNext()){
            PersistentQuantifObject current = (PersistentQuantifObject)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getObject() != null){
                if (current.getObject().getClassId() == classId && current.getObject().getId() == objectId) {
                    PersistentQuantifObject proxi = (PersistentQuantifObject)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentQuantifObject)proxi.getThis());
                }
            }
        }
        candidates = Cache.getTheCache().iterator(181);
        while (candidates.hasNext()){
            PersistentQuantifObject current = (PersistentQuantifObject)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getObject() != null){
                if (current.getObject().getClassId() == classId && current.getObject().getId() == objectId) {
                    PersistentQuantifObject proxi = (PersistentQuantifObject)PersistentProxi.createProxi(current.getId(), current.getClassId());
                    result.add((PersistentQuantifObject)proxi.getThis());
                }
            }
        }
        return result;
    }

}

