package persistence;

public class FractionListEntryProxi extends FractionProxi implements PersistentFractionListEntryProxi {

  long entryId;

  public FractionListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}