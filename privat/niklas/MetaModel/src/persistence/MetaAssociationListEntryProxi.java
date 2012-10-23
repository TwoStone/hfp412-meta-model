package persistence;

public class MetaAssociationListEntryProxi extends MetaAssociationProxi implements PersistentMetaAssociationListEntryProxi {

  long entryId;

  public MetaAssociationListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}