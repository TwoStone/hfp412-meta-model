package persistence;

import model.messageOrLink.*;

import java.util.Iterator;

public class Message_ActualParametersProxi extends PersistentListProxi<PersistentActualParameter> {

  private ActualParameterList list;
  private Message owner;

  public Message_ActualParametersProxi(Message owner) {
    this.owner = owner;
  }
  public ActualParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ActualParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMessageFacade.actualParametersGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentActualParameter> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentActualParameter entry) throws PersistenceException {
    if (entry != null) {
      ActualParameterList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                       .actualParametersAdd(owner.getId(), entry);
      }
      list.add((PersistentActualParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMessageFacade.actualParametersRem(entry.getListEntryId());
    }
    
  }
  public Message_ActualParametersProxi copy(Message owner) throws PersistenceException {
  	Message_ActualParametersProxi result = new Message_ActualParametersProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentActualParameter> entries = (this.list == null ? new java.util.Vector<PersistentActualParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentActualParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                       .actualParametersAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
