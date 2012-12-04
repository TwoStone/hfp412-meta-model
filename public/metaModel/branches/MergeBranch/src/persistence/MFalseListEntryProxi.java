package persistence;

public class MFalseListEntryProxi extends MFalseProxi implements PersistentMFalseListEntryProxi {

  long entryId;

  public MFalseListEntryProxi(long objectId, long entryId) {
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