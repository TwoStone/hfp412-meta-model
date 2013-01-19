package persistence;

public class RemoveLinkCommandListEntryProxi extends RemoveLinkCommandProxi implements PersistentRemoveLinkCommandListEntryProxi {

  long entryId;

  public RemoveLinkCommandListEntryProxi(long objectId, long entryId) {
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