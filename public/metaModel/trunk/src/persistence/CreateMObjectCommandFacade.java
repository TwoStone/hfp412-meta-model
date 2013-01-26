package persistence;

import model.meta.*;

public class CreateMObjectCommandFacade{

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

	

	public CreateMObjectCommandFacade() {
	}

    public CreateMObjectCommandProxi newCreateMObjectCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateMObjectCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 252);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade.getNextId();
        CreateMObjectCommand result = new CreateMObjectCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMObjectCommandProxi)PersistentProxi.createProxi(id, 252);
    }
    
    public CreateMObjectCommandProxi newDelayedCreateMObjectCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade.getNextId();
        CreateMObjectCommand result = new CreateMObjectCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMObjectCommandProxi)PersistentProxi.createProxi(id, 252);
    }
    
    public CreateMObjectCommand getCreateMObjectCommand(long CreateMObjectCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 252)) return 252;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long typesAdd(long CreateMObjectCommandId, PersistentMAtomicType typesVal) throws PersistenceException {
        return 0;
    }
    public void typesRem(long typesId) throws PersistenceException {
        
    }
    public MAtomicTypeList typesGet(long CreateMObjectCommandId) throws PersistenceException {
        return new MAtomicTypeList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateMObjectCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateMObjectCommandId, PersistentObjectManager commandReceiverVal) throws PersistenceException {
        
    }
    public void commandResultSet(long CreateMObjectCommandId, PersistentMObject commandResultVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateMObjectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

