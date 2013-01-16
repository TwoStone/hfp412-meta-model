package persistence;

public class MeasurementTypeManagerListEntryProxi extends MeasurementTypeManagerProxi implements PersistentMeasurementTypeManagerListEntryProxi {

  long entryId;

  public MeasurementTypeManagerListEntryProxi(long objectId, long entryId) {
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