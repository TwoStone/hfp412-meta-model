package persistence;

import model.meta.*;

public class CreateQuantityCommandFacade{

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

	

	public CreateQuantityCommandFacade() {
	}

    public CreateQuantityCommandProxi newCreateQuantityCommand(common.Fraction amount,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateQuantityCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 129);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateQuantityCommandFacade.getNextId();
        CreateQuantityCommand result = new CreateQuantityCommand(null,amount,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateQuantityCommandProxi)PersistentProxi.createProxi(id, 129);
    }
    
    public CreateQuantityCommandProxi newDelayedCreateQuantityCommand(common.Fraction amount) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateQuantityCommandFacade.getNextId();
        CreateQuantityCommand result = new CreateQuantityCommand(null,amount,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateQuantityCommandProxi)PersistentProxi.createProxi(id, 129);
    }
    
    public CreateQuantityCommand getCreateQuantityCommand(long CreateQuantityCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 129)) return 129;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void unitSet(long CreateQuantityCommandId, PersistentAbsUnit unitVal) throws PersistenceException {
        
    }
    public void amountSet(long CreateQuantityCommandId, common.Fraction amountVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateQuantityCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateQuantityCommandId, PersistentQuantityManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateQuantityCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

