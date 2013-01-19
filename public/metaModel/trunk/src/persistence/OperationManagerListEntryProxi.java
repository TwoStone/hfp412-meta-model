package persistence;

public class OperationManagerListEntryProxi extends OperationManagerProxi implements PersistentOperationManagerListEntryProxi {

  long entryId;

  public OperationManagerListEntryProxi(long objectId, long entryId) {
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