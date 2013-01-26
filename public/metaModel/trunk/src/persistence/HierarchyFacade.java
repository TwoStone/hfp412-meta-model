package persistence;

import model.abstractOperation.*;

public class HierarchyFacade{

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

	

	public HierarchyFacade() {
	}

    public HierarchyProxi newHierarchy(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (HierarchyProxi)PersistentProxi.createProxi(createMinusStorePlus, 236);
        long id = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.getNextId();
        Hierarchy result = new Hierarchy(name,null,id);
        Cache.getTheCache().put(result);
        return (HierarchyProxi)PersistentProxi.createProxi(id, 236);
    }
    
    public HierarchyProxi newDelayedHierarchy(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theHierarchyFacade.getNextId();
        Hierarchy result = new Hierarchy(name,null,id);
        Cache.getTheCache().put(result);
        return (HierarchyProxi)PersistentProxi.createProxi(id, 236);
    }
    
    public Hierarchy getHierarchy(long HierarchyId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 236)) return 236;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public HierarchySearchList getHierarchyByName(String name) throws PersistenceException {
        HierarchySearchList result = new HierarchySearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(236);
        while (candidates.hasNext()){
            PersistentHierarchy current = (PersistentHierarchy)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentHierarchy)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long HierarchyId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long HierarchyId, PersistentHierarchy ThisVal) throws PersistenceException {
        
    }

}

