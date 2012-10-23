package persistence;

import java.util.*;

public class ErrorDisplayList {

	protected Vector<PersistentErrorDisplay> data; //List of proxies
	protected ErrorDisplayList() {
		this.data = new Vector<PersistentErrorDisplay>();
	}
	public Iterator<PersistentErrorDisplay> iterator(PersistentListProxi<PersistentErrorDisplay> listProxi) {
		return new PersistentListIterator<PersistentErrorDisplay>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentErrorDisplay entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ErrorDisplayList copy() {
		ErrorDisplayList result = new ErrorDisplayList();
		result.data = (Vector<PersistentErrorDisplay>)this.data.clone();
		return result;
	}


}


