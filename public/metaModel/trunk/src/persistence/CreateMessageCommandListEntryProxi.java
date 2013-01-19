package persistence;

public class CreateMessageCommandListEntryProxi extends CreateMessageCommandProxi implements PersistentCreateMessageCommandListEntryProxi {

  long entryId;

  public CreateMessageCommandListEntryProxi(long objectId, long entryId) {
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