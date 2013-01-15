package persistence;

public class MFormalParameterListEntryProxi extends MFormalParameterProxi implements PersistentMFormalParameterListEntryProxi {

  long entryId;

  public MFormalParameterListEntryProxi(long objectId, long entryId) {
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