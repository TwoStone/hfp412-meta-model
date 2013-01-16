package persistence;

public class AccountManagerListEntryProxi extends AccountManagerProxi implements PersistentAccountManagerListEntryProxi {

  long entryId;

  public AccountManagerListEntryProxi(long objectId, long entryId) {
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