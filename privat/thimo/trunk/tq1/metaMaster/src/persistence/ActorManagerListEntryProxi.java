package persistence;

public class ActorManagerListEntryProxi extends ActorManagerProxi implements PersistentActorManagerListEntryProxi {

  long entryId;

  public ActorManagerListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}