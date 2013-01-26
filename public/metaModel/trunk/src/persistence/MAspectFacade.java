package persistence;

import model.typeSystem.*;

public class MAspectFacade{

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

	

	public MAspectFacade() {
	}

    public MAspectProxi newMAspect(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MAspectProxi)PersistentProxi.createProxi(createMinusStorePlus, 142);
        long id = ConnectionHandler.getTheConnectionHandler().theMAspectFacade.getNextId();
        MAspect result = new MAspect(name,null,id);
        Cache.getTheCache().put(result);
        return (MAspectProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public MAspectProxi newDelayedMAspect(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMAspectFacade.getNextId();
        MAspect result = new MAspect(name,null,id);
        Cache.getTheCache().put(result);
        return (MAspectProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public MAspect getMAspect(long MAspectId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 142)) return 142;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public MAspectSearchList getMAspectByName(String name) throws PersistenceException {
        MAspectSearchList result = new MAspectSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(142);
        while (candidates.hasNext()){
            PersistentMAspect current = (PersistentMAspect)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && current.getName().equals(name))
                result.add((PersistentMAspect)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long MAspectId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long MAspectId, PersistentMAspect ThisVal) throws PersistenceException {
        
    }

}

