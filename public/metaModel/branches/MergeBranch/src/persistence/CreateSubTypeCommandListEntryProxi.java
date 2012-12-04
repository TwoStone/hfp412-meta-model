package persistence;

public class CreateSubTypeCommandListEntryProxi extends CreateSubTypeCommandProxi implements PersistentCreateSubTypeCommandListEntryProxi {

  long entryId;

  public CreateSubTypeCommandListEntryProxi(long objectId, long entryId) {
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