package persistence;

public class PositionSearchList extends SearchListRoot<PersistentPosition> implements Iterable<PersistentPosition> {

	public PositionSearchList(SearchListRoot<PersistentPosition> list){
		super(list);
	}
	public PositionSearchList(){
		super();
	}
	
	public void add (PersistentPosition entry) {
		this.data.add(entry);
	}
	public void add(PositionSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentPosition> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentPosition> iterator() {
		return this.data.iterator();
	}
  
}


