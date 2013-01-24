package persistence;

import model.meta.*;

public class RemoveFpCommandFacade{

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

	

	public RemoveFpCommandFacade() {
	}

    public RemoveFpCommandProxi newRemoveFpCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveFpCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 131);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveFpCommandFacade.getNextId();
        RemoveFpCommand result = new RemoveFpCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveFpCommandProxi)PersistentProxi.createProxi(id, 131);
    }
    
    public RemoveFpCommandProxi newDelayedRemoveFpCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveFpCommandFacade.getNextId();
        RemoveFpCommand result = new RemoveFpCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveFpCommandProxi)PersistentProxi.createProxi(id, 131);
    }
    
    public RemoveFpCommand getRemoveFpCommand(long RemoveFpCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 131)) return 131;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void fpSet(long RemoveFpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveFpCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

