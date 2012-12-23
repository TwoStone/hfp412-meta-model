package persistence;

public class ConversionSearchList extends SearchListRoot<PersistentConversion> implements Iterable<PersistentConversion> {

	public ConversionSearchList(SearchListRoot<PersistentConversion> list){
		super(list);
	}
	public ConversionSearchList(){
		super();
	}
	
	public void add (PersistentConversion entry) {
		this.data.add(entry);
	}
	public void add(ConversionSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentConversion> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentConversion> iterator() {
		return this.data.iterator();
	}
  
}


