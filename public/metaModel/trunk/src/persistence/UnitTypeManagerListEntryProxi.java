package persistence;

public class UnitTypeManagerListEntryProxi extends UnitTypeManagerProxi implements PersistentUnitTypeManagerListEntryProxi {

  long entryId;

  public UnitTypeManagerListEntryProxi(long objectId, long entryId) {
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