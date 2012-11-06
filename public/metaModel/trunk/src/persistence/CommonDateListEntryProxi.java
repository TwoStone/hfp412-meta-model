package persistence;

public class CommonDateListEntryProxi extends CommonDateProxi implements PersistentCommonDateListEntryProxi {

  long entryId;

  public CommonDateListEntryProxi(long objectId, long entryId) {
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