package persistence;

import model.*;

import java.util.Iterator;

public class QuantityManager_QuantitiesProxi extends PersistentListProxi<PersistentQuantity> {

  private QuantityList list;
  private QuantityManager owner;

  public QuantityManager_QuantitiesProxi(QuantityManager owner) {
    this.owner = owner;
  }
  public QuantityList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theQuantityManagerFacade.quantitiesGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentQuantity> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentQuantity entry) throws PersistenceException {
    if (entry != null) {
      QuantityList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade
                       .quantitiesAdd(owner.getId(), entry);
      list.add((PersistentQuantity)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.quantitiesRem(entry.getListEntryId());
    
  }
  public QuantityManager_QuantitiesProxi copy(QuantityManager owner) throws PersistenceException {
  	QuantityManager_QuantitiesProxi result = new QuantityManager_QuantitiesProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
