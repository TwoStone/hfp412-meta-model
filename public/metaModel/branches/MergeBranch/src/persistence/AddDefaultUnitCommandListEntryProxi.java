package persistence;

public class AddDefaultUnitCommandListEntryProxi extends AddDefaultUnitCommandProxi implements PersistentAddDefaultUnitCommandListEntryProxi {

  long entryId;

  public AddDefaultUnitCommandListEntryProxi(long objectId, long entryId) {
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