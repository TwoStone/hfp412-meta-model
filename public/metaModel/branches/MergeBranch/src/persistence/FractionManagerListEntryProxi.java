package persistence;

public class FractionManagerListEntryProxi extends FractionManagerProxi implements PersistentFractionManagerListEntryProxi {

  long entryId;

  public FractionManagerListEntryProxi(long objectId, long entryId) {
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