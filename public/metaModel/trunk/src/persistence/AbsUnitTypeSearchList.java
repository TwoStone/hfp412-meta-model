package persistence;

public class AbsUnitTypeSearchList extends SearchListRoot<PersistentAbsUnitType> implements Iterable<PersistentAbsUnitType> {

	public AbsUnitTypeSearchList(SearchListRoot<PersistentAbsUnitType> list){
		super(list);
	}
	public AbsUnitTypeSearchList(){
		super();
	}
	
	public void add (PersistentAbsUnitType entry) {
		this.data.add(entry);
	}
	public void add(AbsUnitTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAbsUnitType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAbsUnitType> iterator() {
		return this.data.iterator();
	}
  
}


