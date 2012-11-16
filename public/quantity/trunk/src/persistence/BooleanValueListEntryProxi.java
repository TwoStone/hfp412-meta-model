package persistence;

public abstract class BooleanValueListEntryProxi extends BooleanValueProxi implements PersistentBooleanValueListEntryProxi {

  long entryId;

  public BooleanValueListEntryProxi(long objectId, long entryId) {
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