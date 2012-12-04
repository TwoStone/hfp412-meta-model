package persistence;

import java.util.*;

public class MTypeList {

	protected Vector<MType> data; //List of proxies
	protected MTypeList() {
		this.data = new Vector<MType>();
	}
	public Iterator<MType> iterator(PersistentListProxi<MType> listProxi) {
		return new PersistentListIterator<MType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (MType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MTypeList copy() {
		MTypeList result = new MTypeList();
		result.data = (Vector<MType>)this.data.clone();
		return result;
	}


}


