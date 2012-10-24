package persistence;

public abstract class AbsQuantityListEntryProxi extends AbsQuantityProxi implements PersistentAbsQuantityListEntryProxi {

  long entryId;

  public AbsQuantityListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}