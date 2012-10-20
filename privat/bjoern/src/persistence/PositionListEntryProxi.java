package persistence;

public class PositionListEntryProxi extends PositionProxi implements PersistentPositionListEntryProxi {

  long entryId;

  public PositionListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}