package persistence;

public class ObjectManagerListEntryProxi extends ObjectManagerProxi implements PersistentObjectManagerListEntryProxi {

  long entryId;

  public ObjectManagerListEntryProxi(long objectId, long entryId) {
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