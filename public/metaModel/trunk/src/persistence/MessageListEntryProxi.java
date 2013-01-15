package persistence;

public class MessageListEntryProxi extends MessageProxi implements PersistentMessageListEntryProxi {

  long entryId;

  public MessageListEntryProxi(long objectId, long entryId) {
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