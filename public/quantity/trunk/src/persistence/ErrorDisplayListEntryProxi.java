package persistence;

public class ErrorDisplayListEntryProxi extends ErrorDisplayProxi implements PersistentErrorDisplayListEntryProxi {

  long entryId;

  public ErrorDisplayListEntryProxi(long objectId, long entryId) {
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