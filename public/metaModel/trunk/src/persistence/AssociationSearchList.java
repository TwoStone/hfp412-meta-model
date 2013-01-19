package persistence;

public class AssociationSearchList extends SearchListRoot<PersistentAssociation> implements Iterable<PersistentAssociation> {

	public AssociationSearchList(SearchListRoot<PersistentAssociation> list){
		super(list);
	}
	public AssociationSearchList(){
		super();
	}
	
	public void add (PersistentAssociation entry) {
		this.data.add(entry);
	}
	public void add(AssociationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAssociation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAssociation> iterator() {
		return this.data.iterator();
	}
  
}


