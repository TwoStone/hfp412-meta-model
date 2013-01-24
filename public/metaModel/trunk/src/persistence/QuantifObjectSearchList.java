package persistence;

public class QuantifObjectSearchList extends SearchListRoot<PersistentQuantifObject> implements Iterable<PersistentQuantifObject> {

	public QuantifObjectSearchList(SearchListRoot<PersistentQuantifObject> list){
		super(list);
	}
	public QuantifObjectSearchList(){
		super();
	}
	
	public void add (PersistentQuantifObject entry) {
		this.data.add(entry);
	}
	public void add(QuantifObjectSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentQuantifObject> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentQuantifObject> iterator() {
		return this.data.iterator();
	}
  
}


