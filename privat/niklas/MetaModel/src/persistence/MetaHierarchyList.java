package persistence;

import java.util.*;

public class MetaHierarchyList  extends MetaHierarchySearchList{

	protected MetaHierarchyList() {
		super();
	}
	public Iterator<PersistentMetaHierarchy> iterator(PersistentListProxi<PersistentMetaHierarchy> listProxi) {
		return new PersistentListIterator<PersistentMetaHierarchy>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMetaHierarchy entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MetaHierarchyList copy() {
		MetaHierarchyList result = new MetaHierarchyList();
		result.data = (Vector<PersistentMetaHierarchy>)this.data.clone();
		return result;
	}


}


