package persistence;

public class MAHierarchyListEntryProxi extends MAHierarchyProxi implements PersistentMAHierarchyListEntryProxi {

  long entryId;

  public MAHierarchyListEntryProxi(long objectId, long entryId) {
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