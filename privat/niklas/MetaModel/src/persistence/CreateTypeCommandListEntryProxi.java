package persistence;

public class CreateTypeCommandListEntryProxi extends CreateTypeCommandProxi implements PersistentCreateTypeCommandListEntryProxi {

  long entryId;

  public CreateTypeCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}