package persistence;

public class CreateUnitTypeCommandListEntryProxi extends CreateUnitTypeCommandProxi implements PersistentCreateUnitTypeCommandListEntryProxi {

  long entryId;

  public CreateUnitTypeCommandListEntryProxi(long objectId, long entryId) {
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