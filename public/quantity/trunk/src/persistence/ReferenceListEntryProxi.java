package persistence;

public class ReferenceListEntryProxi extends ReferenceProxi implements PersistentReferenceListEntryProxi {

  long entryId;

  public ReferenceListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}