package persistence;

public class CreateStaticOpCommandListEntryProxi extends CreateStaticOpCommandProxi implements PersistentCreateStaticOpCommandListEntryProxi {

  long entryId;

  public CreateStaticOpCommandListEntryProxi(long objectId, long entryId) {
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