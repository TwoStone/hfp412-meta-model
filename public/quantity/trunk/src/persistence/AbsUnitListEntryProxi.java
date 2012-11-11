package persistence;

public abstract class AbsUnitListEntryProxi extends AbsUnitProxi implements PersistentAbsUnitListEntryProxi {

  long entryId;

  public AbsUnitListEntryProxi(long objectId, long entryId) {
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