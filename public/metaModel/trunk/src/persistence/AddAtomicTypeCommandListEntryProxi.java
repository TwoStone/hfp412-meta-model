package persistence;

public class AddAtomicTypeCommandListEntryProxi extends AddAtomicTypeCommandProxi implements PersistentAddAtomicTypeCommandListEntryProxi {

  long entryId;

  public AddAtomicTypeCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}