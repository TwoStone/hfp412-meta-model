package persistence;

public class ReferenceTypeListEntryProxi extends ReferenceTypeProxi implements PersistentReferenceTypeListEntryProxi {

  long entryId;

  public ReferenceTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}