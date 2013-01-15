package persistence;

public abstract class MAbstractSumTypeListEntryProxi extends MAbstractSumTypeProxi implements PersistentMAbstractSumTypeListEntryProxi {

  long entryId;

  public MAbstractSumTypeListEntryProxi(long objectId, long entryId) {
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