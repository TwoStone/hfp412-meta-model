package persistence;

public abstract class ComposedMetaTypeListEntryProxi extends ComposedMetaTypeProxi implements PersistentComposedMetaTypeListEntryProxi {

  long entryId;

  public ComposedMetaTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}