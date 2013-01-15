package persistence;

public class CreateProductTypeCommandListEntryProxi extends CreateProductTypeCommandProxi implements PersistentCreateProductTypeCommandListEntryProxi {

  long entryId;

  public CreateProductTypeCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}