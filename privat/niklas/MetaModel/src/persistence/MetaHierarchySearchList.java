package persistence;

public class MetaHierarchySearchList extends SearchListRoot<PersistentMetaHierarchy> implements Iterable<PersistentMetaHierarchy> {

	public MetaHierarchySearchList(SearchListRoot<PersistentMetaHierarchy> list){
		super(list);
	}
	public MetaHierarchySearchList(){
		super();
	}
	
	public void add (PersistentMetaHierarchy entry) {
		this.data.add(entry);
	}
	public void add(MetaHierarchySearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMetaHierarchy> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMetaHierarchy> iterator() {
		return this.data.iterator();
	}
  
}


