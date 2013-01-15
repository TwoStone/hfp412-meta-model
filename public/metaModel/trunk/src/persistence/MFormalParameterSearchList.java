package persistence;

public class MFormalParameterSearchList extends SearchListRoot<PersistentMFormalParameter> implements Iterable<PersistentMFormalParameter> {

	public MFormalParameterSearchList(SearchListRoot<PersistentMFormalParameter> list){
		super(list);
	}
	public MFormalParameterSearchList(){
		super();
	}
	
	public void add (PersistentMFormalParameter entry) {
		this.data.add(entry);
	}
	public void add(MFormalParameterSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMFormalParameter> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMFormalParameter> iterator() {
		return this.data.iterator();
	}
  
}


