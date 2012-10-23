package persistence;

public class NamedEntitySearchList extends SearchListRoot<PersistentNamedEntity> implements Iterable<PersistentNamedEntity> {

	public NamedEntitySearchList(SearchListRoot<PersistentNamedEntity> list){
		super(list);
	}
	public NamedEntitySearchList(){
		super();
	}
	
	public void add (PersistentNamedEntity entry) {
		this.data.add(entry);
	}
	public void add(NamedEntitySearchList list) throws PersistenceException{
		java.util.Iterator<PersistentNamedEntity> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentNamedEntity> iterator() {
		return this.data.iterator();
	}
  
}


