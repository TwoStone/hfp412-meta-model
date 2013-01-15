package persistence;

public class MAccountTypeListEntryProxi extends MAccountTypeProxi implements PersistentMAccountTypeListEntryProxi {

  long entryId;

  public MAccountTypeListEntryProxi(long objectId, long entryId) {
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