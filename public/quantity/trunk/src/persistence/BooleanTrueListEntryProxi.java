package persistence;

public class BooleanTrueListEntryProxi extends BooleanTrueProxi implements PersistentBooleanTrueListEntryProxi {

  long entryId;

  public BooleanTrueListEntryProxi(long objectId, long entryId) {
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