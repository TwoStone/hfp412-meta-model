package persistence;

public class CreateAspectCommandListEntryProxi extends CreateAspectCommandProxi implements PersistentCreateAspectCommandListEntryProxi {

  long entryId;

  public CreateAspectCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}