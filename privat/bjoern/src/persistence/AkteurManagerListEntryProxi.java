package persistence;

public class AkteurManagerListEntryProxi extends AkteurManagerProxi implements PersistentAkteurManagerListEntryProxi {

  long entryId;

  public AkteurManagerListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}