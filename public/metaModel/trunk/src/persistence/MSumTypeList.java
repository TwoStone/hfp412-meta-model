package persistence;

import java.util.*;

public class MSumTypeList {

	protected Vector<PersistentMSumType> data; //List of proxies
	protected MSumTypeList() {
		this.data = new Vector<PersistentMSumType>();
	}
	public Iterator<PersistentMSumType> iterator(PersistentListProxi<PersistentMSumType> listProxi) {
		return new PersistentListIterator<PersistentMSumType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMSumType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MSumTypeList copy() {
		MSumTypeList result = new MSumTypeList();
		result.data = (Vector<PersistentMSumType>)this.data.clone();
		return result;
	}


}


