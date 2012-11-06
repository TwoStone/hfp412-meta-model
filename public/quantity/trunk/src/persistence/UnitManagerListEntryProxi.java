package persistence;

public class UnitManagerListEntryProxi extends UnitManagerProxi implements PersistentUnitManagerListEntryProxi {

  long entryId;

  public UnitManagerListEntryProxi(long objectId, long entryId) {
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