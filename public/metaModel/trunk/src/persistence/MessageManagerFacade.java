package persistence;

import model.messageOrLink.*;

public class MessageManagerFacade{

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

	

	public MessageManagerFacade() {
	}

    public MessageManagerProxi getTheMessageManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade.getNextId();
        MessageManager result = new MessageManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MessageManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 168);
    }
    
    public MessageManager getMessageManager(long MessageManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 168)) return 168;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long messagesAdd(long MessageManagerId, PersistentMessage messagesVal) throws PersistenceException {
        return 0;
    }
    public void messagesRem(long messagesId) throws PersistenceException {
        
    }
    public MessageList messagesGet(long MessageManagerId) throws PersistenceException {
        return new MessageList(); // remote access for initialization only!
    }
    public void ThisSet(long MessageManagerId, PersistentMessageManager ThisVal) throws PersistenceException {
        
    }

}

