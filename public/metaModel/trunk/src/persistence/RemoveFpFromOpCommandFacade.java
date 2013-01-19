package persistence;

import model.meta.*;

public class RemoveFpFromOpCommandFacade{

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

	

	public RemoveFpFromOpCommandFacade() {
	}

    public RemoveFpFromOpCommandProxi newRemoveFpFromOpCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveFpFromOpCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 197);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveFpFromOpCommandFacade.getNextId();
        RemoveFpFromOpCommand result = new RemoveFpFromOpCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveFpFromOpCommandProxi)PersistentProxi.createProxi(id, 197);
    }
    
    public RemoveFpFromOpCommandProxi newDelayedRemoveFpFromOpCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveFpFromOpCommandFacade.getNextId();
        RemoveFpFromOpCommand result = new RemoveFpFromOpCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveFpFromOpCommandProxi)PersistentProxi.createProxi(id, 197);
    }
    
    public RemoveFpFromOpCommand getRemoveFpFromOpCommand(long RemoveFpFromOpCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 197)) return 197;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void opSet(long RemoveFpFromOpCommandId, PersistentOperation opVal) throws PersistenceException {
        
    }
    public void fpSet(long RemoveFpFromOpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveFpFromOpCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveFpFromOpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveFpFromOpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

