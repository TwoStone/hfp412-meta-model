package persistence;

public class CreateConversionCommandListEntryProxi extends CreateConversionCommandProxi implements PersistentCreateConversionCommandListEntryProxi {

  long entryId;

  public CreateConversionCommandListEntryProxi(long objectId, long entryId) {
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