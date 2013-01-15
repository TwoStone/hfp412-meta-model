package persistence;

public class LinkListEntryProxi extends LinkProxi implements PersistentLinkListEntryProxi {

  long entryId;

  public LinkListEntryProxi(long objectId, long entryId) {
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