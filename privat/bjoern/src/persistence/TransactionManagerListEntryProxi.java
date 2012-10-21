package persistence;

public class TransactionManagerListEntryProxi extends TransactionManagerProxi implements PersistentTransactionManagerListEntryProxi {

  long entryId;

  public TransactionManagerListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}