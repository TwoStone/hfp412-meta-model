package persistence;

public class ActualParameterSearchList extends SearchListRoot<PersistentActualParameter> implements Iterable<PersistentActualParameter> {

	public ActualParameterSearchList(SearchListRoot<PersistentActualParameter> list){
		super(list);
	}
	public ActualParameterSearchList(){
		super();
	}
	
	public void add (PersistentActualParameter entry) {
		this.data.add(entry);
	}
	public void add(ActualParameterSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentActualParameter> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentActualParameter> iterator() {
		return this.data.iterator();
	}
  
}


