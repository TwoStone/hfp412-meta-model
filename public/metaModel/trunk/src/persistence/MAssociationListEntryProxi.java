package persistence;

public class MAssociationListEntryProxi extends MAssociationProxi implements PersistentMAssociationListEntryProxi {

  long entryId;

  public MAssociationListEntryProxi(long objectId, long entryId) {
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