package persistence;

public class CreateConstCommandListEntryProxi extends CreateConstCommandProxi implements PersistentCreateConstCommandListEntryProxi {

  long entryId;

  public CreateConstCommandListEntryProxi(long objectId, long entryId) {
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