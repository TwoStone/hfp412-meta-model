package persistence;

public class OperationSearchList extends SearchListRoot<PersistentOperation> implements Iterable<PersistentOperation> {

	public OperationSearchList(SearchListRoot<PersistentOperation> list){
		super(list);
	}
	public OperationSearchList(){
		super();
	}
	
	public void add (PersistentOperation entry) {
		this.data.add(entry);
	}
	public void add(OperationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentOperation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentOperation> iterator() {
		return this.data.iterator();
	}
  
}


