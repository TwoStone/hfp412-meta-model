package persistence;

public class FormalParameterSearchList extends SearchListRoot<PersistentFormalParameter> implements Iterable<PersistentFormalParameter> {

	public FormalParameterSearchList(SearchListRoot<PersistentFormalParameter> list){
		super(list);
	}
	public FormalParameterSearchList(){
		super();
	}
	
	public void add (PersistentFormalParameter entry) {
		this.data.add(entry);
	}
	public void add(FormalParameterSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentFormalParameter> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentFormalParameter> iterator() {
		return this.data.iterator();
	}
  
}


