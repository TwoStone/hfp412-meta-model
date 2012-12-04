package persistence;

public class MAssociationSearchList extends SearchListRoot<PersistentMAssociation> implements Iterable<PersistentMAssociation> {

	public MAssociationSearchList(SearchListRoot<PersistentMAssociation> list){
		super(list);
	}
	public MAssociationSearchList(){
		super();
	}
	
	public void add (PersistentMAssociation entry) {
		this.data.add(entry);
	}
	public void add(MAssociationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMAssociation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMAssociation> iterator() {
		return this.data.iterator();
	}
  
}


