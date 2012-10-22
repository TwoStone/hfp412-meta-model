package persistence;

public class AddRoleCommandListEntryProxi extends AddRoleCommandProxi implements PersistentAddRoleCommandListEntryProxi {

  long entryId;

  public AddRoleCommandListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}