package persistence;

public class ServerListEntryProxi extends ServerProxi implements PersistentServerListEntryProxi {

  long entryId;

  public ServerListEntryProxi(long objectId, long entryId) {
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