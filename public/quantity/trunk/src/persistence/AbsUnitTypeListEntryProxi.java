package persistence;

public abstract class AbsUnitTypeListEntryProxi extends AbsUnitTypeProxi implements PersistentAbsUnitTypeListEntryProxi {

  long entryId;

  public AbsUnitTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}