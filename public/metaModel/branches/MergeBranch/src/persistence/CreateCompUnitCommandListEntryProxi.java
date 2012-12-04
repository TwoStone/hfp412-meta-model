package persistence;

public class CreateCompUnitCommandListEntryProxi extends CreateCompUnitCommandProxi implements PersistentCreateCompUnitCommandListEntryProxi {

  long entryId;

  public CreateCompUnitCommandListEntryProxi(long objectId, long entryId) {
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