package persistence;

import java.util.*;

public class LinkList {

	protected Vector<PersistentLink> data; //List of proxies
	protected LinkList() {
		this.data = new Vector<PersistentLink>();
	}
	public Iterator<PersistentLink> iterator(PersistentListProxi<PersistentLink> listProxi) {
		return new PersistentListIterator<PersistentLink>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentLink entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected LinkList copy() {
		LinkList result = new LinkList();
		result.data = (Vector<PersistentLink>)this.data.clone();
		return result;
	}


}


