package persistence;

public class CommandExecuterListEntryProxi extends CommandExecuterProxi implements PersistentCommandExecuterListEntryProxi {

  long entryId;

  public CommandExecuterListEntryProxi(long objectId, long entryId) {
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