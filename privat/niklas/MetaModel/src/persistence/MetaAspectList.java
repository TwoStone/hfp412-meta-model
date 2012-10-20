package persistence;

import java.util.*;

public class MetaAspectList {

	protected Vector<PersistentMetaAspect> data; //List of proxies
	protected MetaAspectList() {
		this.data = new Vector<PersistentMetaAspect>();
	}
	public Iterator<PersistentMetaAspect> iterator(PersistentListProxi<PersistentMetaAspect> listProxi) {
		return new PersistentListIterator<PersistentMetaAspect>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMetaAspect entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MetaAspectList copy() {
		MetaAspectList result = new MetaAspectList();
		result.data = (Vector<PersistentMetaAspect>)this.data.clone();
		return result;
	}


}


