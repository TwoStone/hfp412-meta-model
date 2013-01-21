package persistence;

import java.util.*;

public class MObjectList {

	protected Vector<PersistentMObject> data; //List of proxies
	protected MObjectList() {
		this.data = new Vector<PersistentMObject>();
	}
	public Iterator<PersistentMObject> iterator(PersistentListProxi<PersistentMObject> listProxi) {
		return new PersistentListIterator<PersistentMObject>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMObject entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MObjectList copy() {
		MObjectList result = new MObjectList();
		result.data = (Vector<PersistentMObject>)this.data.clone();
		return result;
	}


}


