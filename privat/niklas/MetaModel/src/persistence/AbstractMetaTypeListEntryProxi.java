package persistence;

public abstract class AbstractMetaTypeListEntryProxi extends AbstractMetaTypeProxi implements PersistentAbstractMetaTypeListEntryProxi {

  long entryId;

  public AbstractMetaTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}