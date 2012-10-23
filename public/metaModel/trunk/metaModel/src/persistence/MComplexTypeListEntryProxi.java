package persistence;

public abstract class MComplexTypeListEntryProxi extends MComplexTypeProxi implements PersistentMComplexTypeListEntryProxi {

  long entryId;

  public MComplexTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}