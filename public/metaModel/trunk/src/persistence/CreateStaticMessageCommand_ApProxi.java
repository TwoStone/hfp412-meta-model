package persistence;

import model.meta.*;

import java.util.Iterator;

public class CreateStaticMessageCommand_ApProxi extends PersistentListProxi<PersistentActualParameter> {

  private ActualParameterList list;
  private CreateStaticMessageCommand owner;

  public CreateStaticMessageCommand_ApProxi(CreateStaticMessageCommand owner) {
    this.owner = owner;
  }
  public ActualParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new ActualParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCreateStaticMessageCommandFacade.apGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade
                       .apAdd(owner.getId(), entry);
      }
      list.add((PersistentActualParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade.apRem(entry.getListEntryId());
    }
    
  }
  public CreateStaticMessageCommand_ApProxi copy(CreateStaticMessageCommand owner) throws PersistenceException {
  	CreateStaticMessageCommand_ApProxi result = new CreateStaticMessageCommand_ApProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentActualParameter> entries = (this.list == null ? new java.util.Vector<PersistentActualParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentActualParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade
                       .apAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
