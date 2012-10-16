package persistence;

public class JuristicPersonListEntryProxi extends JuristicPersonProxi implements PersistentJuristicPersonListEntryProxi {

  long entryId;

  public JuristicPersonListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}