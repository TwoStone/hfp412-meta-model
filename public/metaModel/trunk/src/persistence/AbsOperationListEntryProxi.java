package persistence;

public abstract class AbsOperationListEntryProxi extends AbsOperationProxi implements PersistentAbsOperationListEntryProxi {

  long entryId;

  public AbsOperationListEntryProxi(long objectId, long entryId) {
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