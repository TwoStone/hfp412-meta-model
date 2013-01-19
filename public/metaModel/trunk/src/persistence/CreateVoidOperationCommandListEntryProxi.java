package persistence;

public class CreateVoidOperationCommandListEntryProxi extends CreateVoidOperationCommandProxi implements PersistentCreateVoidOperationCommandListEntryProxi {

  long entryId;

  public CreateVoidOperationCommandListEntryProxi(long objectId, long entryId) {
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