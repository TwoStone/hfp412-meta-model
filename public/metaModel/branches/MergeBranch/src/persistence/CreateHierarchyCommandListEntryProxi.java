package persistence;

public class CreateHierarchyCommandListEntryProxi extends CreateHierarchyCommandProxi implements PersistentCreateHierarchyCommandListEntryProxi {

  long entryId;

  public CreateHierarchyCommandListEntryProxi(long objectId, long entryId) {
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