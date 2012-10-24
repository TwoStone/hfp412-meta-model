package persistence;

public class TypeReferenceListEntryProxi extends TypeReferenceProxi implements PersistentTypeReferenceListEntryProxi {

  long entryId;

  public TypeReferenceListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}