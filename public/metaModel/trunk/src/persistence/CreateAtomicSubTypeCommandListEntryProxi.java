package persistence;

public class CreateAtomicSubTypeCommandListEntryProxi extends CreateAtomicSubTypeCommandProxi implements PersistentCreateAtomicSubTypeCommandListEntryProxi {

  long entryId;

  public CreateAtomicSubTypeCommandListEntryProxi(long objectId, long entryId) {
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