package persistence;

public class BooleanFalseListEntryProxi extends BooleanFalseProxi implements PersistentBooleanFalseListEntryProxi {

  long entryId;

  public BooleanFalseListEntryProxi(long objectId, long entryId) {
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