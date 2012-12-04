package persistence;

public class CreateCompUnitTypeCommandListEntryProxi extends CreateCompUnitTypeCommandProxi implements PersistentCreateCompUnitTypeCommandListEntryProxi {

  long entryId;

  public CreateCompUnitTypeCommandListEntryProxi(long objectId, long entryId) {
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