package persistence;

public class CreateAssociationCommandListEntryProxi extends CreateAssociationCommandProxi implements PersistentCreateAssociationCommandListEntryProxi {

  long entryId;

  public CreateAssociationCommandListEntryProxi(long objectId, long entryId) {
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