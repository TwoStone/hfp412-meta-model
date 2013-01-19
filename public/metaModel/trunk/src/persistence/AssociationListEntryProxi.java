package persistence;

public class AssociationListEntryProxi extends AssociationProxi implements PersistentAssociationListEntryProxi {

  long entryId;

  public AssociationListEntryProxi(long objectId, long entryId) {
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