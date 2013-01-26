package persistence;

public class MEmptyProductTypeListEntryProxi extends MEmptyProductTypeProxi implements PersistentMEmptyProductTypeListEntryProxi {

  long entryId;

  public MEmptyProductTypeListEntryProxi(long objectId, long entryId) {
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