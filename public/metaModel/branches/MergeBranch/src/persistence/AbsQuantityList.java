package persistence;

import java.util.*;

public class AbsQuantityList {

	protected Vector<PersistentAbsQuantity> data; //List of proxies
	protected AbsQuantityList() {
		this.data = new Vector<PersistentAbsQuantity>();
	}
	public Iterator<PersistentAbsQuantity> iterator(PersistentListProxi<PersistentAbsQuantity> listProxi) {
		return new PersistentListIterator<PersistentAbsQuantity>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAbsQuantity entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AbsQuantityList copy() {
		AbsQuantityList result = new AbsQuantityList();
		result.data = (Vector<PersistentAbsQuantity>)this.data.clone();
		return result;
	}


}


