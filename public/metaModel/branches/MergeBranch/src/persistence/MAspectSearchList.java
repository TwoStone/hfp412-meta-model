package persistence;

public class MAspectSearchList extends SearchListRoot<PersistentMAspect> implements Iterable<PersistentMAspect> {

	public MAspectSearchList(SearchListRoot<PersistentMAspect> list){
		super(list);
	}
	public MAspectSearchList(){
		super();
	}
	
	public void add (PersistentMAspect entry) {
		this.data.add(entry);
	}
	public void add(MAspectSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMAspect> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMAspect> iterator() {
		return this.data.iterator();
	}
  
}


