package persistence;

public class MObjectListEntryProxi extends MObjectProxi implements PersistentMObjectListEntryProxi {

  long entryId;

  public MObjectListEntryProxi(long objectId, long entryId) {
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