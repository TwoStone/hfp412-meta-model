package persistence;

public abstract class MessageOrLinkListEntryProxi extends MessageOrLinkProxi implements PersistentMessageOrLinkListEntryProxi {

  long entryId;

  public MessageOrLinkListEntryProxi(long objectId, long entryId) {
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