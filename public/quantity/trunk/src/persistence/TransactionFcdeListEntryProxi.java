package persistence;

public class TransactionFcdeListEntryProxi extends TransactionFcdeProxi implements PersistentTransactionFcdeListEntryProxi {

  long entryId;

  public TransactionFcdeListEntryProxi(long objectId, long entryId) {
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