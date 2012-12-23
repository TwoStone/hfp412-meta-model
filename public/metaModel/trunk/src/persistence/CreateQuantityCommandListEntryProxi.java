package persistence;

public class CreateQuantityCommandListEntryProxi extends CreateQuantityCommandProxi implements PersistentCreateQuantityCommandListEntryProxi {

  long entryId;

  public CreateQuantityCommandListEntryProxi(long objectId, long entryId) {
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