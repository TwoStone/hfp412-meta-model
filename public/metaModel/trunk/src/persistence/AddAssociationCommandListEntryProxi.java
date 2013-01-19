package persistence;

public class AddAssociationCommandListEntryProxi extends AddAssociationCommandProxi implements PersistentAddAssociationCommandListEntryProxi {

  long entryId;

  public AddAssociationCommandListEntryProxi(long objectId, long entryId) {
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