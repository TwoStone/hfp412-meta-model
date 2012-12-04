package persistence;

public class CreateUnitCommandListEntryProxi extends CreateUnitCommandProxi implements PersistentCreateUnitCommandListEntryProxi {

  long entryId;

  public CreateUnitCommandListEntryProxi(long objectId, long entryId) {
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