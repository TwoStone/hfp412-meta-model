package persistence;

public class MTypeSearchList extends SearchListRoot<PersistentMType> implements Iterable<PersistentMType> {

	public MTypeSearchList(SearchListRoot<PersistentMType> list){
		super(list);
	}
	public MTypeSearchList(){
		super();
	}
	
	public void add (PersistentMType entry) {
		this.data.add(entry);
	}
	public void add(MTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMType> iterator() {
		return this.data.iterator();
	}
  
}


