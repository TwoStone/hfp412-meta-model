package persistence;

public class MTypeSearchList extends SearchListRoot<MType> implements Iterable<MType> {

	public MTypeSearchList(SearchListRoot<MType> list){
		super(list);
	}
	public MTypeSearchList(){
		super();
	}
	
	public void add (MType entry) {
		this.data.add(entry);
	}
	public void add(MTypeSearchList list) throws PersistenceException{
		java.util.Iterator<MType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<MType> iterator() {
		return this.data.iterator();
	}
  
}


