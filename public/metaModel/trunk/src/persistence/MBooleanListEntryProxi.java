package persistence;

public abstract class MBooleanListEntryProxi extends MBooleanProxi implements PersistentMBooleanListEntryProxi {

  long entryId;

  public MBooleanListEntryProxi(long objectId, long entryId) {
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