package persistence;

public class AbsOperationSearchList extends SearchListRoot<PersistentAbsOperation> implements Iterable<PersistentAbsOperation> {

	public AbsOperationSearchList(SearchListRoot<PersistentAbsOperation> list){
		super(list);
	}
	public AbsOperationSearchList(){
		super();
	}
	
	public void add (PersistentAbsOperation entry) {
		this.data.add(entry);
	}
	public void add(AbsOperationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAbsOperation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAbsOperation> iterator() {
		return this.data.iterator();
	}
  
}


