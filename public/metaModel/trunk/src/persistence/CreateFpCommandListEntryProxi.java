package persistence;

public class CreateFpCommandListEntryProxi extends CreateFpCommandProxi implements PersistentCreateFpCommandListEntryProxi {

  long entryId;

  public CreateFpCommandListEntryProxi(long objectId, long entryId) {
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