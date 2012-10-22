package persistence;

public class RolleSearchList extends SearchListRoot<PersistentRolle> implements Iterable<PersistentRolle> {

	public RolleSearchList(SearchListRoot<PersistentRolle> list){
		super(list);
	}
	public RolleSearchList(){
		super();
	}
	
	public void add (PersistentRolle entry) {
		this.data.add(entry);
	}
	public void add(RolleSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentRolle> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentRolle> iterator() {
		return this.data.iterator();
	}
  
}


