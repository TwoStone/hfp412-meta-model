package persistence;

public class AbstractMetaTypeSearchList extends SearchListRoot<PersistentAbstractMetaType> implements Iterable<PersistentAbstractMetaType> {

	public AbstractMetaTypeSearchList(SearchListRoot<PersistentAbstractMetaType> list){
		super(list);
	}
	public AbstractMetaTypeSearchList(){
		super();
	}
	
	public void add (PersistentAbstractMetaType entry) {
		this.data.add(entry);
	}
	public void add(AbstractMetaTypeSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAbstractMetaType> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAbstractMetaType> iterator() {
		return this.data.iterator();
	}
  
}


