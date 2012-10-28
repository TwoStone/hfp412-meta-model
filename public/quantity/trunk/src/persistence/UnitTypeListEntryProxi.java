package persistence;

public class UnitTypeListEntryProxi extends UnitTypeProxi implements PersistentUnitTypeListEntryProxi {

  long entryId;

  public UnitTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}