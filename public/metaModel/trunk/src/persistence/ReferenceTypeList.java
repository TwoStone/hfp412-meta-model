package persistence;

import java.util.*;

public class ReferenceTypeList {

	protected Vector<PersistentReferenceType> data; //List of proxies
	protected ReferenceTypeList() {
		this.data = new Vector<PersistentReferenceType>();
	}
	public Iterator<PersistentReferenceType> iterator(PersistentListProxi<PersistentReferenceType> listProxi) {
		return new PersistentListIterator<PersistentReferenceType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentReferenceType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ReferenceTypeList copy() {
		ReferenceTypeList result = new ReferenceTypeList();
		result.data = (Vector<PersistentReferenceType>)this.data.clone();
		return result;
	}


}


