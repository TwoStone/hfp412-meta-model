package persistence;

public class CONCNamedEntityListEntryProxi extends CONCNamedEntityProxi implements PersistentCONCNamedEntityListEntryProxi {

  long entryId;

  public CONCNamedEntityListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}