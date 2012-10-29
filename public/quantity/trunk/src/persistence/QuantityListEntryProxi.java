package persistence;

public class QuantityListEntryProxi extends QuantityProxi implements PersistentQuantityListEntryProxi {

  long entryId;

  public QuantityListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}