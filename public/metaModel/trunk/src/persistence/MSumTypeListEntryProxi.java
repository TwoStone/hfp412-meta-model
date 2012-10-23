package persistence;

public class MSumTypeListEntryProxi extends MSumTypeProxi implements PersistentMSumTypeListEntryProxi {

  long entryId;

  public MSumTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}