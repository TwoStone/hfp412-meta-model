package persistence;

public class ProduktListEntryProxi extends ProduktProxi implements PersistentProduktListEntryProxi {

  long entryId;

  public ProduktListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}