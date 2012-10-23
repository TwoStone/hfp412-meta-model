package persistence;

public class MProductTypeListEntryProxi extends MProductTypeProxi implements PersistentMProductTypeListEntryProxi {

  long entryId;

  public MProductTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}