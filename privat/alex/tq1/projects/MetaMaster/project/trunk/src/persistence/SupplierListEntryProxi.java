package persistence;

public class SupplierListEntryProxi extends SupplierProxi implements PersistentSupplierListEntryProxi {

  long entryId;

  public SupplierListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}