package persistence;

public class CommandCoordinatorListEntryProxi extends CommandCoordinatorProxi implements PersistentCommandCoordinatorListEntryProxi {

  long entryId;

  public CommandCoordinatorListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}