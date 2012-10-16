package persistence;

public class RoleSearchList extends SearchListRoot<PersistentRole> implements Iterable<PersistentRole> {

	public RoleSearchList(SearchListRoot<PersistentRole> list){
		super(list);
	}
	public RoleSearchList(){
		super();
	}
	
	public void add (PersistentRole entry) {
		this.data.add(entry);
	}
	public void add(RoleSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentRole> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentRole> iterator() {
		return this.data.iterator();
	}
  
}


