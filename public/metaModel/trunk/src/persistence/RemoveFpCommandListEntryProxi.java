package persistence;

public class RemoveFpCommandListEntryProxi extends RemoveFpCommandProxi implements PersistentRemoveFpCommandListEntryProxi {

  long entryId;

  public RemoveFpCommandListEntryProxi(long objectId, long entryId) {
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