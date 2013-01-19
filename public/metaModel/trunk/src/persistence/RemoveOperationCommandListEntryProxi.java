package persistence;

public class RemoveOperationCommandListEntryProxi extends RemoveOperationCommandProxi implements PersistentRemoveOperationCommandListEntryProxi {

  long entryId;

  public RemoveOperationCommandListEntryProxi(long objectId, long entryId) {
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