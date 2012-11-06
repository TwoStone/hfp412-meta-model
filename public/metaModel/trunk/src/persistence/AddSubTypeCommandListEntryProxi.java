package persistence;

public class AddSubTypeCommandListEntryProxi extends AddSubTypeCommandProxi implements PersistentAddSubTypeCommandListEntryProxi {

  long entryId;

  public AddSubTypeCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}