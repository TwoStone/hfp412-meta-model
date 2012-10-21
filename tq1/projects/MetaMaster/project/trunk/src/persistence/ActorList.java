package persistence;

import java.util.*;

public class ActorList  extends ActorSearchList{

	protected ActorList() {
		super();
	}
	public Iterator<PersistentActor> iterator(PersistentListProxi<PersistentActor> listProxi) {
		return new PersistentListIterator<PersistentActor>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentActor entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ActorList copy() {
		ActorList result = new ActorList();
		result.data = (Vector<PersistentActor>)this.data.clone();
		return result;
	}


}


