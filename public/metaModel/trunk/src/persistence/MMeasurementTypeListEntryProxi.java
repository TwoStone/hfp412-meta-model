package persistence;

public class MMeasurementTypeListEntryProxi extends MMeasurementTypeProxi implements PersistentMMeasurementTypeListEntryProxi {

  long entryId;

  public MMeasurementTypeListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}