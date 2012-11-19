package persistence;

public class FinalizeCommandListEntryProxi extends FinalizeCommandProxi implements PersistentFinalizeCommandListEntryProxi {

  long entryId;

  public FinalizeCommandListEntryProxi(long objectId, long entryId) {
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