package persistence;

public class CreateAkteurCommandListEntryProxi extends CreateAkteurCommandProxi implements PersistentCreateAkteurCommandListEntryProxi {

  long entryId;

  public CreateAkteurCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}