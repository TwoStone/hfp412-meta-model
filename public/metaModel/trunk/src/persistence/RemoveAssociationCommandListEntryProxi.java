package persistence;

public class RemoveAssociationCommandListEntryProxi extends RemoveAssociationCommandProxi implements PersistentRemoveAssociationCommandListEntryProxi {

  long entryId;

  public RemoveAssociationCommandListEntryProxi(long objectId, long entryId) {
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