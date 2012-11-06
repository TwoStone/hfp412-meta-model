package persistence;

public class CompoundQuantityListEntryProxi extends CompoundQuantityProxi implements PersistentCompoundQuantityListEntryProxi {

  long entryId;

  public CompoundQuantityListEntryProxi(long objectId, long entryId) {
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