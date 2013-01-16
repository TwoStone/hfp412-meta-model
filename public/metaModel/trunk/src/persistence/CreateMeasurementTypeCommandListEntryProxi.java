package persistence;

public class CreateMeasurementTypeCommandListEntryProxi extends CreateMeasurementTypeCommandProxi implements PersistentCreateMeasurementTypeCommandListEntryProxi {

  long entryId;

  public CreateMeasurementTypeCommandListEntryProxi(long objectId, long entryId) {
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