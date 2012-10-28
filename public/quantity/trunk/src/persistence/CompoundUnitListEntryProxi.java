package persistence;

public class CompoundUnitListEntryProxi extends CompoundUnitProxi implements PersistentCompoundUnitListEntryProxi {

  long entryId;

  public CompoundUnitListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}