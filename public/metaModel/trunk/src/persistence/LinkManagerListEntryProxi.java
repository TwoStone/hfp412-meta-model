package persistence;

public class LinkManagerListEntryProxi extends LinkManagerProxi implements PersistentLinkManagerListEntryProxi {

  long entryId;

  public LinkManagerListEntryProxi(long objectId, long entryId) {
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