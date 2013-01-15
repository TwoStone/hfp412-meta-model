package persistence;

import model.*;

public class MessageFacade{



	public MessageFacade() {
	}

    public MessageProxi newMessage(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (MessageProxi)PersistentProxi.createProxi(createMinusStorePlus, 198);
        long id = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.getNextId();
        Message result = new Message(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MessageProxi)PersistentProxi.createProxi(id, 198);
    }
    
    public MessageProxi newDelayedMessage() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.getNextId();
        Message result = new Message(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (MessageProxi)PersistentProxi.createProxi(id, 198);
    }
    
    public Message getMessage(long MessageId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void typeSet(long MessageId, PersistentMOperation typeVal) throws PersistenceException {
        
    }

}

