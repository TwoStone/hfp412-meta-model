package persistence;

public class CompoundUnitTypeListEntryProxi extends CompoundUnitTypeProxi implements PersistentCompoundUnitTypeListEntryProxi {

  long entryId;

  public CompoundUnitTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}