package persistence;

public class CreateOperationCommandListEntryProxi extends CreateOperationCommandProxi implements PersistentCreateOperationCommandListEntryProxi {

  long entryId;

  public CreateOperationCommandListEntryProxi(long objectId, long entryId) {
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