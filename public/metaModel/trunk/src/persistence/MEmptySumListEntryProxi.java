package persistence;

public class MEmptySumListEntryProxi extends MEmptySumProxi implements PersistentMEmptySumListEntryProxi {

  long entryId;

  public MEmptySumListEntryProxi(long objectId, long entryId) {
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