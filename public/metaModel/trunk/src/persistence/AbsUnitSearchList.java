package persistence;

public class AbsUnitSearchList extends SearchListRoot<PersistentAbsUnit> implements Iterable<PersistentAbsUnit> {

	public AbsUnitSearchList(SearchListRoot<PersistentAbsUnit> list){
		super(list);
	}
	public AbsUnitSearchList(){
		super();
	}
	
	public void add (PersistentAbsUnit entry) {
		this.data.add(entry);
	}
	public void add(AbsUnitSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAbsUnit> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAbsUnit> iterator() {
		return this.data.iterator();
	}
  
}


