package persistence;

public class MOperationListEntryProxi extends MOperationProxi implements PersistentMOperationListEntryProxi {

  long entryId;

  public MOperationListEntryProxi(long objectId, long entryId) {
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