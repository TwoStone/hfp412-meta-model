package persistence;

import model.meta.*;

public class RemoveMessageCommandFacade{

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

	

	public RemoveMessageCommandFacade() {
	}

    public RemoveMessageCommandProxi newRemoveMessageCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveMessageCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 198);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveMessageCommandFacade.getNextId();
        RemoveMessageCommand result = new RemoveMessageCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveMessageCommandProxi)PersistentProxi.createProxi(id, 198);
    }
    
    public RemoveMessageCommandProxi newDelayedRemoveMessageCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveMessageCommandFacade.getNextId();
        RemoveMessageCommand result = new RemoveMessageCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveMessageCommandProxi)PersistentProxi.createProxi(id, 198);
    }
    
    public RemoveMessageCommand getRemoveMessageCommand(long RemoveMessageCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 198)) return 198;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void mSet(long RemoveMessageCommandId, PersistentMessage mVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveMessageCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

