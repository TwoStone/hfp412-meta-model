package persistence;

import model.typeSystem.*;

public class MObjectFacade{

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

	

	public MObjectFacade() {
	}

    public MObjectProxi newMObject(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MObjectProxi)PersistentProxi.createProxi(createMinusStorePlus, 236);
        long id = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.getNextId();
        MObject result = new MObject(null,id);
        Cache.getTheCache().put(result);
        return (MObjectProxi)PersistentProxi.createProxi(id, 236);
    }
    
    public MObjectProxi newDelayedMObject() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.getNextId();
        MObject result = new MObject(null,id);
        Cache.getTheCache().put(result);
        return (MObjectProxi)PersistentProxi.createProxi(id, 236);
    }
    
    public MObject getMObject(long MObjectId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 236)) return 236;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MObjectId, PersistentMObject ThisVal) throws PersistenceException {
        
    }

}

