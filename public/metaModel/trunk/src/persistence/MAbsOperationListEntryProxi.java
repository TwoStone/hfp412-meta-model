package persistence;

public abstract class MAbsOperationListEntryProxi extends MAbsOperationProxi implements PersistentMAbsOperationListEntryProxi {

  long entryId;

  public MAbsOperationListEntryProxi(long objectId, long entryId) {
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