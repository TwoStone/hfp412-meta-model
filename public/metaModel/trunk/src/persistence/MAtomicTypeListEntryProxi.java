package persistence;

public class MAtomicTypeListEntryProxi extends MAtomicTypeProxi implements PersistentMAtomicTypeListEntryProxi {

  long entryId;

  public MAtomicTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}