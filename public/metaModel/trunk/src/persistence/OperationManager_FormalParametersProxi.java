package persistence;

import model.abstractOperation.*;

import java.util.Iterator;

public class OperationManager_FormalParametersProxi extends PersistentListProxi<PersistentFormalParameter> {

  private FormalParameterList list;
  private OperationManager owner;

  public OperationManager_FormalParametersProxi(OperationManager owner) {
    this.owner = owner;
  }
  public FormalParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new FormalParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theOperationManagerFacade.formalParametersGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
                       .formalParametersAdd(owner.getId(), entry);
      }
      list.add((PersistentFormalParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade.formalParametersRem(entry.getListEntryId());
    }
    
  }
  public OperationManager_FormalParametersProxi copy(OperationManager owner) throws PersistenceException {
  	OperationManager_FormalParametersProxi result = new OperationManager_FormalParametersProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentFormalParameter> entries = (this.list == null ? new java.util.Vector<PersistentFormalParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentFormalParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
                       .formalParametersAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
