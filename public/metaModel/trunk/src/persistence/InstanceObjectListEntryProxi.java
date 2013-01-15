package persistence;

public class InstanceObjectListEntryProxi extends InstanceObjectProxi implements PersistentInstanceObjectListEntryProxi {

  long entryId;

  public InstanceObjectListEntryProxi(long objectId, long entryId) {
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