package persistence;

public class MeasurementListEntryProxi extends MeasurementProxi implements PersistentMeasurementListEntryProxi {

  long entryId;

  public MeasurementListEntryProxi(long objectId, long entryId) {
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