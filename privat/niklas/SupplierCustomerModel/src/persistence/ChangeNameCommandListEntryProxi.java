package persistence;

public class ChangeNameCommandListEntryProxi extends ChangeNameCommandProxi implements PersistentChangeNameCommandListEntryProxi {

  long entryId;

  public ChangeNameCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}