package persistence;

public class AddToHierarchyCommandListEntryProxi extends AddToHierarchyCommandProxi implements PersistentAddToHierarchyCommandListEntryProxi {

  long entryId;

  public AddToHierarchyCommandListEntryProxi(long objectId, long entryId) {
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