package persistence;

public class AccountListEntryProxi extends AccountProxi implements PersistentAccountListEntryProxi {

  long entryId;

  public AccountListEntryProxi(long objectId, long entryId) {
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