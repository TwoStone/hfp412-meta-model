package persistence;

import model.meta.*;

import java.util.Iterator;

public class CreateMessageCommand_ApProxi extends PersistentListProxi<PersistentActualParameter> {

  private ActualParameterList list;
  private CreateMessageCommand owner;

  public CreateMessageCommand_ApProxi(CreateMessageCommand owner) {
    this.owner = owner;
  }
  public ActualParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ActualParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCreateMessageCommandFacade.apGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
                       .apAdd(owner.getId(), entry);
      }
      list.add((PersistentActualParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.apRem(entry.getListEntryId());
    }
    
  }
  public CreateMessageCommand_ApProxi copy(CreateMessageCommand owner) throws PersistenceException {
  	CreateMessageCommand_ApProxi result = new CreateMessageCommand_ApProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentActualParameter> entries = (this.list == null ? new java.util.Vector<PersistentActualParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentActualParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
                       .apAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
