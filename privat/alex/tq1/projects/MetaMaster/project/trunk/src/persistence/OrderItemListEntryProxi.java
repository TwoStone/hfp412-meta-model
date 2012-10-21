package persistence;

public class OrderItemListEntryProxi extends OrderItemProxi implements PersistentOrderItemListEntryProxi {

  long entryId;

  public OrderItemListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}