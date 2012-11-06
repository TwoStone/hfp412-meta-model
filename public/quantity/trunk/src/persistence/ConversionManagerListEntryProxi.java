package persistence;

public class ConversionManagerListEntryProxi extends ConversionManagerProxi implements PersistentConversionManagerListEntryProxi {

  long entryId;

  public ConversionManagerListEntryProxi(long objectId, long entryId) {
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