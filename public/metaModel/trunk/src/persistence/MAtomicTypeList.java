package persistence;

import java.util.*;

public class MAtomicTypeList {

	protected Vector<PersistentMAtomicType> data; //List of proxies
	protected MAtomicTypeList() {
		this.data = new Vector<PersistentMAtomicType>();
	}
	public Iterator<PersistentMAtomicType> iterator(PersistentListProxi<PersistentMAtomicType> listProxi) {
		return new PersistentListIterator<PersistentMAtomicType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMAtomicType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MAtomicTypeList copy() {
		MAtomicTypeList result = new MAtomicTypeList();
		result.data = (Vector<PersistentMAtomicType>)this.data.clone();
		return result;
	}


}


