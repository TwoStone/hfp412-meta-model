package persistence;

import model.meta.*;

public class CreateSumTypeCommandFacade{

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

	

	public CreateSumTypeCommandFacade() {
	}

    public CreateSumTypeCommandProxi newCreateSumTypeCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateSumTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 196);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateSumTypeCommandFacade.getNextId();
        CreateSumTypeCommand result = new CreateSumTypeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateSumTypeCommandProxi)PersistentProxi.createProxi(id, 196);
    }
    
    public CreateSumTypeCommandProxi newDelayedCreateSumTypeCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateSumTypeCommandFacade.getNextId();
        CreateSumTypeCommand result = new CreateSumTypeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateSumTypeCommandProxi)PersistentProxi.createProxi(id, 196);
    }
    
    public CreateSumTypeCommand getCreateSumTypeCommand(long CreateSumTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 196)) return 196;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long addendsAdd(long CreateSumTypeCommandId, PersistentMType addendsVal) throws PersistenceException {
        return 0;
    }
    public void addendsRem(long addendsId) throws PersistenceException {
        
    }
    public MTypeList addendsGet(long CreateSumTypeCommandId) throws PersistenceException {
        return new MTypeList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateSumTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateSumTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void commandResultSet(long CreateSumTypeCommandId, PersistentMAbstractSumType commandResultVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateSumTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

