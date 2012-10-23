package persistence;

public class OrMetaTypeListEntryProxi extends OrMetaTypeProxi implements PersistentOrMetaTypeListEntryProxi {

  long entryId;

  public OrMetaTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}