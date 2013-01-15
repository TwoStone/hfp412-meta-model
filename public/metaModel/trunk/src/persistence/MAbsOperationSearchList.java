package persistence;

public class MAbsOperationSearchList extends SearchListRoot<PersistentMAbsOperation> implements Iterable<PersistentMAbsOperation> {

	public MAbsOperationSearchList(SearchListRoot<PersistentMAbsOperation> list){
		super(list);
	}
	public MAbsOperationSearchList(){
		super();
	}
	
	public void add (PersistentMAbsOperation entry) {
		this.data.add(entry);
	}
	public void add(MAbsOperationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMAbsOperation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMAbsOperation> iterator() {
		return this.data.iterator();
	}
  
}


