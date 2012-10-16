package persistence;

public class ActorListEntryProxi extends ActorProxi implements PersistentActorListEntryProxi {

  long entryId;

  public ActorListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}