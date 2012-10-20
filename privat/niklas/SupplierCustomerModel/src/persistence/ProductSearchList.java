package persistence;

public class ProductSearchList extends SearchListRoot<PersistentProduct> implements Iterable<PersistentProduct> {

	public ProductSearchList(SearchListRoot<PersistentProduct> list){
		super(list);
	}
	public ProductSearchList(){
		super();
	}
	
	public void add (PersistentProduct entry) {
		this.data.add(entry);
	}
	public void add(ProductSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentProduct> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentProduct> iterator() {
		return this.data.iterator();
	}
  
}


