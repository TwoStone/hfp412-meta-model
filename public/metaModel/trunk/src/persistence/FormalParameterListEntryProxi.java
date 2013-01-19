package persistence;

public class FormalParameterListEntryProxi extends FormalParameterProxi implements PersistentFormalParameterListEntryProxi {

  long entryId;

  public FormalParameterListEntryProxi(long objectId, long entryId) {
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