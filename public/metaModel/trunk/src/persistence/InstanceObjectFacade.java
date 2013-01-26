package persistence;

import model.*;

public class InstanceObjectFacade{

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

	

	public InstanceObjectFacade() {
	}

    public InstanceObjectProxi newInstanceObject(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (InstanceObjectProxi)PersistentProxi.createProxi(createMinusStorePlus, 132);
        long id = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.getNextId();
        InstanceObject result = new InstanceObject(null,null,id);
        Cache.getTheCache().put(result);
        return (InstanceObjectProxi)PersistentProxi.createProxi(id, 132);
    }
    
    public InstanceObjectProxi newDelayedInstanceObject() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.getNextId();
        InstanceObject result = new InstanceObject(null,null,id);
        Cache.getTheCache().put(result);
        return (InstanceObjectProxi)PersistentProxi.createProxi(id, 132);
    }
    
    public InstanceObject getInstanceObject(long InstanceObjectId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 132)) return 132;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long InstanceObjectId, PersistentMAtomicType typeVal) throws PersistenceException {
        
    }
    public void ThisSet(long InstanceObjectId, PersistentInstanceObject ThisVal) throws PersistenceException {
        
    }

}

