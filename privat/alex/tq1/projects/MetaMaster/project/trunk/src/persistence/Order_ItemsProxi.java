package persistence;

import model.*;

import java.util.Iterator;

public class Order_ItemsProxi extends PersistentListProxi<PersistentOrderItem> {

  private OrderItemList list;
  private Order owner;

  public Order_ItemsProxi(Order owner) {
    this.owner = owner;
  }
  public OrderItemList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theOrderFacade.itemsGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentOrderItem> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentOrderItem entry) throws PersistenceException {
    if (entry != null) {
      OrderItemList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theOrderFacade
                       .itemsAdd(owner.getId(), entry);
      list.add((PersistentOrderItem)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theOrderFacade.itemsRem(entry.getListEntryId());
    
  }
  public Order_ItemsProxi copy(Order owner) throws PersistenceException {
  	Order_ItemsProxi result = new Order_ItemsProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
