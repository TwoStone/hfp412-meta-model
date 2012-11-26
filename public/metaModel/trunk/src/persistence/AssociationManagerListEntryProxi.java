package persistence;

public class AssociationManagerListEntryProxi extends AssociationManagerProxi implements PersistentAssociationManagerListEntryProxi {

  long entryId;

  public AssociationManagerListEntryProxi(long objectId, long entryId) {
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