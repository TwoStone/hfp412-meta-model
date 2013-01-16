package persistence;

public class UnitTypeSearchList extends SearchListRoot<PersistentUnitType> implements Iterable<PersistentUnitType> {

	public UnitTypeSearchList(SearchListRoot<PersistentUnitType> list){
		super(list);
	}
	public UnitTypeSearchList(){
		super();
	}
	
	public void add (PersistentUnitType entry) {
		this.data.add(entry);
	}
	public void add(UnitTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentUnitType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentUnitType> iterator() {
		return this.data.iterator();
	}
  
}


