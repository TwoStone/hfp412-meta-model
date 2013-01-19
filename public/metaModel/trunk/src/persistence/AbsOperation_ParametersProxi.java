package persistence;

import model.abstractOperation.*;

import java.util.Iterator;

public class AbsOperation_ParametersProxi extends PersistentListProxi<PersistentFormalParameter> {

  private FormalParameterList list;
  private AbsOperation owner;

  public AbsOperation_ParametersProxi(AbsOperation owner) {
    this.owner = owner;
  }
  public FormalParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new FormalParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theAbsOperationFacade.parametersGet(this.owner.getId());
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
        entryId = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade
                       .parametersAdd(owner.getId(), entry);
      }
      list.add((PersistentFormalParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.parametersRem(entry.getListEntryId());
    }
    
  }
  public AbsOperation_ParametersProxi copy(AbsOperation owner) throws PersistenceException {
  	AbsOperation_ParametersProxi result = new AbsOperation_ParametersProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentFormalParameter> entries = (this.list == null ? new java.util.Vector<PersistentFormalParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentFormalParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade
                       .parametersAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
