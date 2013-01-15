package persistence;

public class ActualParameterListEntryProxi extends ActualParameterProxi implements PersistentActualParameterListEntryProxi {

  long entryId;

  public ActualParameterListEntryProxi(long objectId, long entryId) {
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