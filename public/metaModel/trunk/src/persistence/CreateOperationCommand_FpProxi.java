package persistence;

import model.meta.*;

import java.util.Iterator;

public class CreateOperationCommand_FpProxi extends PersistentListProxi<PersistentFormalParameter> {

  private FormalParameterList list;
  private CreateOperationCommand owner;

  public CreateOperationCommand_FpProxi(CreateOperationCommand owner) {
    this.owner = owner;
  }
  public FormalParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new FormalParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theCreateOperationCommandFacade.fpGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentFormalParameter> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentFormalParameter entry) throws PersistenceException {
    if (entry != null) {
      FormalParameterList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
                       .fpAdd(owner.getId(), entry);
      }
      list.add((PersistentFormalParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.fpRem(entry.getListEntryId());
    }
    
  }
  public CreateOperationCommand_FpProxi copy(CreateOperationCommand owner) throws PersistenceException {
  	CreateOperationCommand_FpProxi result = new CreateOperationCommand_FpProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentFormalParameter> entries = (this.list == null ? new java.util.Vector<PersistentFormalParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentFormalParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
                       .fpAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
