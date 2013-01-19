package persistence;

import model.abstractOperation.*;

import java.util.Iterator;

public class OperationManager_OperationsProxi extends PersistentListProxi<PersistentOperation> {

  private OperationList list;
  private OperationManager owner;

  public OperationManager_OperationsProxi(OperationManager owner) {
    this.owner = owner;
  }
  public OperationList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new OperationList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theOperationManagerFacade.operationsGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentOperation> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentOperation entry) throws PersistenceException {
    if (entry != null) {
      OperationList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
                       .operationsAdd(owner.getId(), entry);
      }
      list.add((PersistentOperation)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade.operationsRem(entry.getListEntryId());
    }
    
  }
  public OperationManager_OperationsProxi copy(OperationManager owner) throws PersistenceException {
  	OperationManager_OperationsProxi result = new OperationManager_OperationsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentOperation> entries = (this.list == null ? new java.util.Vector<PersistentOperation>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentOperation current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
                       .operationsAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
