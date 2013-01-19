package persistence;

import java.util.*;

public class MessageList {

	protected Vector<PersistentMessage> data; //List of proxies
	protected MessageList() {
		this.data = new Vector<PersistentMessage>();
	}
	public Iterator<PersistentMessage> iterator(PersistentListProxi<PersistentMessage> listProxi) {
		return new PersistentListIterator<PersistentMessage>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMessage entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MessageList copy() {
		MessageList result = new MessageList();
		result.data = (Vector<PersistentMessage>)this.data.clone();
		return result;
	}


}


