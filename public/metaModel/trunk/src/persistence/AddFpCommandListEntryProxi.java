package persistence;

public class AddFpCommandListEntryProxi extends AddFpCommandProxi implements PersistentAddFpCommandListEntryProxi {

  long entryId;

  public AddFpCommandListEntryProxi(long objectId, long entryId) {
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