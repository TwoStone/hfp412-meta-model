package persistence;

public class AddPositionCommandListEntryProxi extends AddPositionCommandProxi implements PersistentAddPositionCommandListEntryProxi {

  long entryId;

  public AddPositionCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}