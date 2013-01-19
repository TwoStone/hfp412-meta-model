package persistence;

public class CreateLinkCommandListEntryProxi extends CreateLinkCommandProxi implements PersistentCreateLinkCommandListEntryProxi {

  long entryId;

  public CreateLinkCommandListEntryProxi(long objectId, long entryId) {
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