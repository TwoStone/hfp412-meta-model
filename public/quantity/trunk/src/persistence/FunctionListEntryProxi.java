package persistence;

public class FunctionListEntryProxi extends FunctionProxi implements PersistentFunctionListEntryProxi {

  long entryId;

  public FunctionListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }

}