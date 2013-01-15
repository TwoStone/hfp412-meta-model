package persistence;

public abstract class QuantifObjectListEntryProxi extends QuantifObjectProxi implements PersistentQuantifObjectListEntryProxi {

  long entryId;

  public QuantifObjectListEntryProxi(long objectId, long entryId) {
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