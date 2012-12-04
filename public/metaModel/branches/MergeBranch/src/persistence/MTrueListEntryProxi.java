package persistence;

public class MTrueListEntryProxi extends MTrueProxi implements PersistentMTrueListEntryProxi {

  long entryId;

  public MTrueListEntryProxi(long objectId, long entryId) {
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