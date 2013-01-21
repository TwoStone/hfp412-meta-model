package persistence;

public class CreateMObjectCommandListEntryProxi extends CreateMObjectCommandProxi implements PersistentCreateMObjectCommandListEntryProxi {

  long entryId;

  public CreateMObjectCommandListEntryProxi(long objectId, long entryId) {
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