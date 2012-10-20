package persistence;

public class CreateOrderCommandListEntryProxi extends CreateOrderCommandProxi implements PersistentCreateOrderCommandListEntryProxi {

  long entryId;

  public CreateOrderCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}