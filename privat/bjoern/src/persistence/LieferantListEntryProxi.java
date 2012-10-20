package persistence;

public class LieferantListEntryProxi extends LieferantProxi implements PersistentLieferantListEntryProxi {

  long entryId;

  public LieferantListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}