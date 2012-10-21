package persistence;

import java.util.*;

public class OrderItemList {

	protected Vector<PersistentOrderItem> data; //List of proxies
	protected OrderItemList() {
		this.data = new Vector<PersistentOrderItem>();
	}
	public Iterator<PersistentOrderItem> iterator(PersistentListProxi<PersistentOrderItem> listProxi) {
		return new PersistentListIterator<PersistentOrderItem>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentOrderItem entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected OrderItemList copy() {
		OrderItemList result = new OrderItemList();
		result.data = (Vector<PersistentOrderItem>)this.data.clone();
		return result;
	}


}


