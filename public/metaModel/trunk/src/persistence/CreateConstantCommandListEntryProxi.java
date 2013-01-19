package persistence;

public class CreateConstantCommandListEntryProxi extends CreateConstantCommandProxi implements PersistentCreateConstantCommandListEntryProxi {

  long entryId;

  public CreateConstantCommandListEntryProxi(long objectId, long entryId) {
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