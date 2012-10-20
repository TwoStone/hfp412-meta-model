package persistence;

public abstract class RolleListEntryProxi extends RolleProxi implements PersistentRolleListEntryProxi {

  long entryId;

  public RolleListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}