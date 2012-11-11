package persistence;

import java.util.*;

public class AbsUnitTypeList {

	protected Vector<PersistentAbsUnitType> data; //List of proxies
	protected AbsUnitTypeList() {
		this.data = new Vector<PersistentAbsUnitType>();
	}
	public Iterator<PersistentAbsUnitType> iterator(PersistentListProxi<PersistentAbsUnitType> listProxi) {
		return new PersistentListIterator<PersistentAbsUnitType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAbsUnitType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AbsUnitTypeList copy() {
		AbsUnitTypeList result = new AbsUnitTypeList();
		result.data = (Vector<PersistentAbsUnitType>)this.data.clone();
		return result;
	}


}


