package persistence;

public class AkteurSearchList extends SearchListRoot<PersistentAkteur> implements Iterable<PersistentAkteur> {

	public AkteurSearchList(SearchListRoot<PersistentAkteur> list){
		super(list);
	}
	public AkteurSearchList(){
		super();
	}
	
	public void add (PersistentAkteur entry) {
		this.data.add(entry);
	}
	public void add(AkteurSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAkteur> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAkteur> iterator() {
		return this.data.iterator();
	}
  
}


