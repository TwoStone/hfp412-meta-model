package persistence;

import model.*;

import java.util.Iterator;

public class ComposedQuantity_PartsProxi extends PersistentListProxi<PersistentQuantity> {

  private QuantityList list;
  private ComposedQuantity owner;

  public ComposedQuantity_PartsProxi(ComposedQuantity owner) {
    this.owner = owner;
  }
  public QuantityList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theComposedQuantityFacade.partsGet(this.owner.getId());
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
      long entryId = ConnectionHandler.getTheConnectionHandler().theComposedQuantityFacade
                       .partsAdd(owner.getId(), entry);
      list.add((PersistentQuantity)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theComposedQuantityFacade.partsRem(entry.getListEntryId());
    
  }
  public ComposedQuantity_PartsProxi copy(ComposedQuantity owner) throws PersistenceException {
  	ComposedQuantity_PartsProxi result = new ComposedQuantity_PartsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
