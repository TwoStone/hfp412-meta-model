package persistence;

public class MetaTypeListEntryProxi extends MetaTypeProxi implements PersistentMetaTypeListEntryProxi {

  long entryId;

  public MetaTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}