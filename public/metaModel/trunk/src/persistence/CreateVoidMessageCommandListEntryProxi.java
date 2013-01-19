package persistence;

public class CreateVoidMessageCommandListEntryProxi extends CreateVoidMessageCommandProxi implements PersistentCreateVoidMessageCommandListEntryProxi {

  long entryId;

  public CreateVoidMessageCommandListEntryProxi(long objectId, long entryId) {
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