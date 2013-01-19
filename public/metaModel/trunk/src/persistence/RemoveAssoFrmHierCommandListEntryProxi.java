package persistence;

public class RemoveAssoFrmHierCommandListEntryProxi extends RemoveAssoFrmHierCommandProxi implements PersistentRemoveAssoFrmHierCommandListEntryProxi {

  long entryId;

  public RemoveAssoFrmHierCommandListEntryProxi(long objectId, long entryId) {
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