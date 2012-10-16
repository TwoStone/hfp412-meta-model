package persistence;

public class ActorSearchList extends SearchListRoot<PersistentActor> implements Iterable<PersistentActor> {

	public ActorSearchList(SearchListRoot<PersistentActor> list){
		super(list);
	}
	public ActorSearchList(){
		super();
	}
	
	public void add (PersistentActor entry) {
		this.data.add(entry);
	}
	public void add(ActorSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentActor> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentActor> iterator() {
		return this.data.iterator();
	}
  
}


