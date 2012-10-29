package persistence;

import java.util.*;

public class MProductTypeList {

	protected Vector<PersistentMProductType> data; //List of proxies
	protected MProductTypeList() {
		this.data = new Vector<PersistentMProductType>();
	}
	public Iterator<PersistentMProductType> iterator(PersistentListProxi<PersistentMProductType> listProxi) {
		return new PersistentListIterator<PersistentMProductType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMProductType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MProductTypeList copy() {
		MProductTypeList result = new MProductTypeList();
		result.data = (Vector<PersistentMProductType>)this.data.clone();
		return result;
	}


}


