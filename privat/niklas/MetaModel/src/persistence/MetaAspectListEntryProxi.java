package persistence;

public class MetaAspectListEntryProxi extends MetaAspectProxi implements PersistentMetaAspectListEntryProxi {

  long entryId;

  public MetaAspectListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}