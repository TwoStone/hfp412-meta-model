package persistence;

import model.*;

import java.util.Iterator;

public class MAbsOperation_ParametersProxi extends PersistentListProxi<PersistentMFormalParameter> {

  private MFormalParameterList list;
  private MAbsOperation owner;

  public MAbsOperation_ParametersProxi(MAbsOperation owner) {
    this.owner = owner;
  }
  public MFormalParameterList getList() throws PersistenceException{
    if (this.list == null) {
      if (this.owner.isDelayed$Persistence()) {
        this.list = new MFormalParameterList();
      } else {
        this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theMAbsOperationFacade.parametersGet(this.owner.getId());
      }
    }
    return this.list;
  }
  public Iterator<PersistentMFormalParameter> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentMFormalParameter entry) throws PersistenceException {
    if (entry != null) {
      MFormalParameterList list = this.getList();
      long entryId = 0;
      if (!this.owner.isDelayed$Persistence()) {
        entry.store();  	
        entryId = ConnectionHandler.getTheConnectionHandler().theMAbsOperationFacade
                       .parametersAdd(owner.getId(), entry);
      }
      list.add((PersistentMFormalParameter)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    if (!this.owner.isDelayed$Persistence()) {
      ConnectionHandler.getTheConnectionHandler().theMAbsOperationFacade.parametersRem(entry.getListEntryId());
    }
    
  }
  public MAbsOperation_ParametersProxi copy(MAbsOperation owner) throws PersistenceException {
  	MAbsOperation_ParametersProxi result = new MAbsOperation_ParametersProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 
  public void store() throws PersistenceException {
  	java.util.Iterator<PersistentMFormalParameter> entries = (this.list == null ? new java.util.Vector<PersistentMFormalParameter>().iterator() : this.list.iterator(this));
  	while (entries.hasNext()){
  		PersistentMFormalParameter current = entries.next();
  		current.store();
      	long entryId = ConnectionHandler.getTheConnectionHandler().theMAbsOperationFacade
                       .parametersAdd(owner.getId(), current);
        ((PersistentListEntryProxi)current).setListEntryId(entryId);
  	}
  }	
}
