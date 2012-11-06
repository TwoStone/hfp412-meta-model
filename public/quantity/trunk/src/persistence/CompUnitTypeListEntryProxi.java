package persistence;

public class CompUnitTypeListEntryProxi extends CompUnitTypeProxi implements PersistentCompUnitTypeListEntryProxi {

  long entryId;

  public CompUnitTypeListEntryProxi(long objectId, long entryId) {
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