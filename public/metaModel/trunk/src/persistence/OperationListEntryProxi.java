package persistence;

public class OperationListEntryProxi extends OperationProxi implements PersistentOperationListEntryProxi {

  long entryId;

  public OperationListEntryProxi(long objectId, long entryId) {
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