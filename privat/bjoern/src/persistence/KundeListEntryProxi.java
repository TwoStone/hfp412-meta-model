package persistence;

public class KundeListEntryProxi extends KundeProxi implements PersistentKundeListEntryProxi {

  long entryId;

  public KundeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}