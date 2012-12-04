package persistence;

public class AddReferenceTypeCommandListEntryProxi extends AddReferenceTypeCommandProxi implements PersistentAddReferenceTypeCommandListEntryProxi {

  long entryId;

  public AddReferenceTypeCommandListEntryProxi(long objectId, long entryId) {
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