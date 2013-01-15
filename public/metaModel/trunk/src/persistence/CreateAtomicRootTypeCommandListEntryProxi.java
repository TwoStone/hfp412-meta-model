package persistence;

public class CreateAtomicRootTypeCommandListEntryProxi extends CreateAtomicRootTypeCommandProxi implements PersistentCreateAtomicRootTypeCommandListEntryProxi {

  long entryId;

  public CreateAtomicRootTypeCommandListEntryProxi(long objectId, long entryId) {
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