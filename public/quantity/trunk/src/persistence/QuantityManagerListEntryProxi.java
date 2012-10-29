package persistence;

public class QuantityManagerListEntryProxi extends QuantityManagerProxi implements PersistentQuantityManagerListEntryProxi {

  long entryId;

  public QuantityManagerListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}