package persistence;

public class CreateSumTypeCommandListEntryProxi extends CreateSumTypeCommandProxi implements PersistentCreateSumTypeCommandListEntryProxi {

  long entryId;

  public CreateSumTypeCommandListEntryProxi(long objectId, long entryId) {
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