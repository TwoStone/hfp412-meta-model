package persistence;

public class ConversionListEntryProxi extends ConversionProxi implements PersistentConversionListEntryProxi {

  long entryId;

  public ConversionListEntryProxi(long objectId, long entryId) {
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