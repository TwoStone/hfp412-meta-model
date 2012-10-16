package persistence;

public abstract class RoleListEntryProxi extends RoleProxi implements PersistentRoleListEntryProxi {

  long entryId;

  public RoleListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}