package persistence;

public class ServerSearchList extends SearchListRoot<PersistentServer> implements Iterable<PersistentServer> {

	public ServerSearchList(SearchListRoot<PersistentServer> list){
		super(list);
	}
	public ServerSearchList(){
		super();
	}
	
	public void add (PersistentServer entry) {
		this.data.add(entry);
	}
	public void add(ServerSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentServer> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentServer> iterator() {
		return this.data.iterator();
	}
  
}


