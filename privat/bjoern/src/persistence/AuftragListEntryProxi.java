package persistence;

public class AuftragListEntryProxi extends AuftragProxi implements PersistentAuftragListEntryProxi {

  long entryId;

  public AuftragListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}