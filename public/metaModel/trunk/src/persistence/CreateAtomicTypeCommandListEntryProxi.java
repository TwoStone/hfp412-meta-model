package persistence;

public class CreateAtomicTypeCommandListEntryProxi extends CreateAtomicTypeCommandProxi implements PersistentCreateAtomicTypeCommandListEntryProxi {

  long entryId;

  public CreateAtomicTypeCommandListEntryProxi(long objectId, long entryId) {
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