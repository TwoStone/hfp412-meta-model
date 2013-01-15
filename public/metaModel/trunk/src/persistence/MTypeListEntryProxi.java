package persistence;

public abstract class MTypeListEntryProxi extends MTypeProxi implements PersistentMTypeListEntryProxi {

  long entryId;

  public MTypeListEntryProxi(long objectId, long entryId) {
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