package persistence;

public class CreateActorCommandListEntryProxi extends CreateActorCommandProxi implements PersistentCreateActorCommandListEntryProxi {

  long entryId;

  public CreateActorCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}