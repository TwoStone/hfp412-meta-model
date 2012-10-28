package persistence;

public class ComposedQuantityListEntryProxi extends ComposedQuantityProxi implements PersistentComposedQuantityListEntryProxi {

  long entryId;

  public ComposedQuantityListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}