package persistence;

public class AndMetaTypeListEntryProxi extends AndMetaTypeProxi implements PersistentAndMetaTypeListEntryProxi {

  long entryId;

  public AndMetaTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}