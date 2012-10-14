package persistence;

import java.util.*;

public class ProductList {

	protected Vector<PersistentProduct> data; //List of proxies
	protected ProductList() {
		this.data = new Vector<PersistentProduct>();
	}
	public Iterator<PersistentProduct> iterator(PersistentListProxi<PersistentProduct> listProxi) {
		return new PersistentListIterator<PersistentProduct>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentProduct entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ProductList copy() {
		ProductList result = new ProductList();
		result.data = (Vector<PersistentProduct>)this.data.clone();
		return result;
	}


}


