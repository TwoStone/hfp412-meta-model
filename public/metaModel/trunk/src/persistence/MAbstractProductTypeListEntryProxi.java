package persistence;

public class MAbstractProductTypeListEntryProxi extends MAbstractProductTypeProxi implements PersistentMAbstractProductTypeListEntryProxi {

  long entryId;

  public MAbstractProductTypeListEntryProxi(long objectId, long entryId) {
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