package persistence;

public class MetaTypeSearchList extends SearchListRoot<PersistentMetaType> implements Iterable<PersistentMetaType> {

	public MetaTypeSearchList(SearchListRoot<PersistentMetaType> list){
		super(list);
	}
	public MetaTypeSearchList(){
		super();
	}
	
	public void add (PersistentMetaType entry) {
		this.data.add(entry);
	}
	public void add(MetaTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMetaType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMetaType> iterator() {
		return this.data.iterator();
	}
  
}


