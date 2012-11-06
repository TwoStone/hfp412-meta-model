package persistence;

public class CompUnitListEntryProxi extends CompUnitProxi implements PersistentCompUnitListEntryProxi {

  long entryId;

  public CompUnitListEntryProxi(long objectId, long entryId) {
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