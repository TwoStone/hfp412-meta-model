package persistence;

public class UnitReferenceListEntryProxi extends UnitReferenceProxi implements PersistentUnitReferenceListEntryProxi {

  long entryId;

  public UnitReferenceListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}