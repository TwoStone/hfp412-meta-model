package persistence;

public class HierarchySearchList extends SearchListRoot<PersistentHierarchy> implements Iterable<PersistentHierarchy> {

	public HierarchySearchList(SearchListRoot<PersistentHierarchy> list){
		super(list);
	}
	public HierarchySearchList(){
		super();
	}
	
	public void add (PersistentHierarchy entry) {
		this.data.add(entry);
	}
	public void add(HierarchySearchList list) throws PersistenceException{
		java.util.Iterator<PersistentHierarchy> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentHierarchy> iterator() {
		return this.data.iterator();
	}
  
}


