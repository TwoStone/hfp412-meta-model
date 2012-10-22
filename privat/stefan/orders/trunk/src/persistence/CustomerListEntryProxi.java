package persistence;

public class CustomerListEntryProxi extends CustomerProxi implements PersistentCustomerListEntryProxi {

  long entryId;

  public CustomerListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}