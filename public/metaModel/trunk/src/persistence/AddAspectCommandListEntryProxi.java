package persistence;

public class AddAspectCommandListEntryProxi extends AddAspectCommandProxi implements PersistentAddAspectCommandListEntryProxi {

  long entryId;

  public AddAspectCommandListEntryProxi(long objectId, long entryId) {
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