package persistence;

import java.util.*;

public class ReferenceList {

	protected Vector<PersistentReference> data; //List of proxies
	protected ReferenceList() {
		this.data = new Vector<PersistentReference>();
	}
	public Iterator<PersistentReference> iterator(PersistentListProxi<PersistentReference> listProxi) {
		return new PersistentListIterator<PersistentReference>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentReference entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ReferenceList copy() {
		ReferenceList result = new ReferenceList();
		result.data = (Vector<PersistentReference>)this.data.clone();
		return result;
	}


}


