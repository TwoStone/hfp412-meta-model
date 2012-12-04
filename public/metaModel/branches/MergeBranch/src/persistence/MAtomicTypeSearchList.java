package persistence;

public class MAtomicTypeSearchList extends SearchListRoot<PersistentMAtomicType> implements Iterable<PersistentMAtomicType> {

	public MAtomicTypeSearchList(SearchListRoot<PersistentMAtomicType> list){
		super(list);
	}
	public MAtomicTypeSearchList(){
		super();
	}
	
	public void add (PersistentMAtomicType entry) {
		this.data.add(entry);
	}
	public void add(MAtomicTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMAtomicType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMAtomicType> iterator() {
		return this.data.iterator();
	}
  
}


