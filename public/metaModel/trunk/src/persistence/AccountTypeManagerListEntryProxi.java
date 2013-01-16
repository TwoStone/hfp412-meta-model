package persistence;

public class AccountTypeManagerListEntryProxi extends AccountTypeManagerProxi implements PersistentAccountTypeManagerListEntryProxi {

  long entryId;

  public AccountTypeManagerListEntryProxi(long objectId, long entryId) {
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