package persistence;

import model.messageOrLink.*;

import java.util.Iterator;

public class MessageManager_MessagesProxi extends PersistentListProxi<PersistentMessage> {

  private MessageList list;
  private MessageManager owner;

  public MessageManager_MessagesProxi(MessageManager owner) {
    this.owner = owner;
  }
  public MessageList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MessageList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMessageManagerFacade.messagesGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMessage> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMessage entry) throws PersistenceException {
    if (entry != null) {
      MessageList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade
                       .messagesAdd(owner.getId(), entry);
      }
      list.add((PersistentMessage)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade.messagesRem(entry.getListEntryId());
    }
    
  }
  public MessageManager_MessagesProxi copy(MessageManager owner) throws PersistenceException {
  	MessageManager_MessagesProxi result = new MessageManager_MessagesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMessage> entries = (this.list == null ? new java.util.Vector<PersistentMessage>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMessage current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade
                       .messagesAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
