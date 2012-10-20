package persistence;

public class AkteurListEntryProxi extends AkteurProxi implements PersistentAkteurListEntryProxi {

  long entryId;

  public AkteurListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}