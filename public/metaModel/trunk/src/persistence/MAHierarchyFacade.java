package persistence;

import model.*;

public class MAHierarchyFacade{

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

	

	public MAHierarchyFacade() {
	}

    public MAHierarchyProxi newMAHierarchy(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAHierarchyProxi)PersistentProxi.createProxi(createMinusStorePlus, 142);
        long id = ConnectionHandler.getTheConnectionHandler().theMAHierarchyFacade.getNextId();
        MAHierarchy result = new MAHierarchy(name,null,id);
        Cache.getTheCache().put(result);
        return (MAHierarchyProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public MAHierarchyProxi newDelayedMAHierarchy(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMAHierarchyFacade.getNextId();
        MAHierarchy result = new MAHierarchy(name,null,id);
        Cache.getTheCache().put(result);
        return (MAHierarchyProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public MAHierarchy getMAHierarchy(long MAHierarchyId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 142)) return 142;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public MAHierarchySearchList getMAHierarchyByName(String name) throws PersistenceException {
        MAHierarchySearchList result = new MAHierarchySearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(142);
        while (candidates.hasNext()){
            PersistentMAHierarchy current = (PersistentMAHierarchy)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMAHierarchy)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long MAHierarchyId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long MAHierarchyId, PersistentMAHierarchy ThisVal) throws PersistenceException {
        
    }

}

