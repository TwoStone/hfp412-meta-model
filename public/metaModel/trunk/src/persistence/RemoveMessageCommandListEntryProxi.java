package persistence;

public class RemoveMessageCommandListEntryProxi extends RemoveMessageCommandProxi implements PersistentRemoveMessageCommandListEntryProxi {

  long entryId;

  public RemoveMessageCommandListEntryProxi(long objectId, long entryId) {
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