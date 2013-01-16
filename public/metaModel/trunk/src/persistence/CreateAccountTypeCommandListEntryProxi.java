package persistence;

public class CreateAccountTypeCommandListEntryProxi extends CreateAccountTypeCommandProxi implements PersistentCreateAccountTypeCommandListEntryProxi {

  long entryId;

  public CreateAccountTypeCommandListEntryProxi(long objectId, long entryId) {
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