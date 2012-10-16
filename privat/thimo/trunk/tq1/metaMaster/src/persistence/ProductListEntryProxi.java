package persistence;

public class ProductListEntryProxi extends ProductProxi implements PersistentProductListEntryProxi {

  long entryId;

  public ProductListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}