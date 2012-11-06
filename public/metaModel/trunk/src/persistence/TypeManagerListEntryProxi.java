package persistence;

public class TypeManagerListEntryProxi extends TypeManagerProxi implements PersistentTypeManagerListEntryProxi {

  long entryId;

  public TypeManagerListEntryProxi(long objectId, long entryId) {
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