package persistence;

public class MAHierarchySearchList extends SearchListRoot<PersistentMAHierarchy> implements Iterable<PersistentMAHierarchy> {

	public MAHierarchySearchList(SearchListRoot<PersistentMAHierarchy> list){
		super(list);
	}
	public MAHierarchySearchList(){
		super();
	}
	
	public void add (PersistentMAHierarchy entry) {
		this.data.add(entry);
	}
	public void add(MAHierarchySearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMAHierarchy> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMAHierarchy> iterator() {
		return this.data.iterator();
	}
  
}


