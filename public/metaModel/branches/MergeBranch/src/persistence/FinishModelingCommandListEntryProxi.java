package persistence;

public class FinishModelingCommandListEntryProxi extends FinishModelingCommandProxi implements PersistentFinishModelingCommandListEntryProxi {

  long entryId;

  public FinishModelingCommandListEntryProxi(long objectId, long entryId) {
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