package persistence;

public abstract class MQuantiObjectTypeListEntryProxi extends MQuantiObjectTypeProxi implements PersistentMQuantiObjectTypeListEntryProxi {

  long entryId;

  public MQuantiObjectTypeListEntryProxi(long objectId, long entryId) {
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