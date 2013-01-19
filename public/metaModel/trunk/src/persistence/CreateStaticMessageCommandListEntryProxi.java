package persistence;

public class CreateStaticMessageCommandListEntryProxi extends CreateStaticMessageCommandProxi implements PersistentCreateStaticMessageCommandListEntryProxi {

  long entryId;

  public CreateStaticMessageCommandListEntryProxi(long objectId, long entryId) {
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