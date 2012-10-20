package persistence;

public class OrderSearchList extends SearchListRoot<PersistentOrder> implements Iterable<PersistentOrder> {

	public OrderSearchList(SearchListRoot<PersistentOrder> list){
		super(list);
	}
	public OrderSearchList(){
		super();
	}
	
	public void add (PersistentOrder entry) {
		this.data.add(entry);
	}
	public void add(OrderSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentOrder> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentOrder> iterator() {
		return this.data.iterator();
	}
  
}


