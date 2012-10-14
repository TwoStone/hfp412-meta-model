package persistence;

public class NaturalPersonListEntryProxi extends NaturalPersonProxi implements PersistentNaturalPersonListEntryProxi {

  long entryId;

  public NaturalPersonListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}