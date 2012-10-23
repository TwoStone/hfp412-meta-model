package persistence;

public class MetaHierarchyListEntryProxi extends MetaHierarchyProxi implements PersistentMetaHierarchyListEntryProxi {

  long entryId;

  public MetaHierarchyListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}