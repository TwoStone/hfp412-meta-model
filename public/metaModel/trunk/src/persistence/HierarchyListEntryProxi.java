package persistence;

public class HierarchyListEntryProxi extends HierarchyProxi implements PersistentHierarchyListEntryProxi {

  long entryId;

  public HierarchyListEntryProxi(long objectId, long entryId) {
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