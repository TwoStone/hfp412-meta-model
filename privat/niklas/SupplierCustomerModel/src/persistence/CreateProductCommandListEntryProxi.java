package persistence;

public class CreateProductCommandListEntryProxi extends CreateProductCommandProxi implements PersistentCreateProductCommandListEntryProxi {

  long entryId;

  public CreateProductCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}