package persistence;

public class MEmptyProductListEntryProxi extends MEmptyProductProxi implements PersistentMEmptyProductListEntryProxi {

  long entryId;

  public MEmptyProductListEntryProxi(long objectId, long entryId) {
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