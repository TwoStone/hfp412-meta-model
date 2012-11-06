package persistence;

public class AspectManagerListEntryProxi extends AspectManagerProxi implements PersistentAspectManagerListEntryProxi {

  long entryId;

  public AspectManagerListEntryProxi(long objectId, long entryId) {
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