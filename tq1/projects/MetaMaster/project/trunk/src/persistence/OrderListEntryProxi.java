package persistence;

public class OrderListEntryProxi extends OrderProxi implements PersistentOrderListEntryProxi {

  long entryId;

  public OrderListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}