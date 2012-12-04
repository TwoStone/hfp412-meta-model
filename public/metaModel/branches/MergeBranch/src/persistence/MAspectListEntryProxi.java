package persistence;

public class MAspectListEntryProxi extends MAspectProxi implements PersistentMAspectListEntryProxi {

  long entryId;

  public MAspectListEntryProxi(long objectId, long entryId) {
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