package persistence;

public abstract class NamedEntityListEntryProxi extends NamedEntityProxi implements PersistentNamedEntityListEntryProxi {

  long entryId;

  public NamedEntityListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}