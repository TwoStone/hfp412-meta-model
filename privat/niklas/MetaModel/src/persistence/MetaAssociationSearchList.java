package persistence;

public class MetaAssociationSearchList extends SearchListRoot<PersistentMetaAssociation> implements Iterable<PersistentMetaAssociation> {

	public MetaAssociationSearchList(SearchListRoot<PersistentMetaAssociation> list){
		super(list);
	}
	public MetaAssociationSearchList(){
		super();
	}
	
	public void add (PersistentMetaAssociation entry) {
		this.data.add(entry);
	}
	public void add(MetaAssociationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentMetaAssociation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentMetaAssociation> iterator() {
		return this.data.iterator();
	}
  
}


