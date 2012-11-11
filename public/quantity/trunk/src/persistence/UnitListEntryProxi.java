package persistence;

public class UnitListEntryProxi extends UnitProxi implements PersistentUnitListEntryProxi {

  long entryId;

  public UnitListEntryProxi(long objectId, long entryId) {
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