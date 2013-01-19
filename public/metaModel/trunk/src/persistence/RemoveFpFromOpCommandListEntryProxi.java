package persistence;

public class RemoveFpFromOpCommandListEntryProxi extends RemoveFpFromOpCommandProxi implements PersistentRemoveFpFromOpCommandListEntryProxi {

  long entryId;

  public RemoveFpFromOpCommandListEntryProxi(long objectId, long entryId) {
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