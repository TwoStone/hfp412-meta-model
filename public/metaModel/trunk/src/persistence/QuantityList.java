package persistence;

import java.util.*;

public class QuantityList {

	protected Vector<PersistentQuantity> data; //List of proxies
	protected QuantityList() {
		this.data = new Vector<PersistentQuantity>();
	}
	public Iterator<PersistentQuantity> iterator(PersistentListProxi<PersistentQuantity> listProxi) {
		return new PersistentListIterator<PersistentQuantity>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentQuantity entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected QuantityList copy() {
		QuantityList result = new QuantityList();
		result.data = (Vector<PersistentQuantity>)this.data.clone();
		return result;
	}


}


