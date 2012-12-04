package persistence;

import java.util.*;

public class MAHierarchyList  extends MAHierarchySearchList{

	protected MAHierarchyList() {
		super();
	}
	public Iterator<PersistentMAHierarchy> iterator(PersistentListProxi<PersistentMAHierarchy> listProxi) {
		return new PersistentListIterator<PersistentMAHierarchy>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMAHierarchy entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MAHierarchyList copy() {
		MAHierarchyList result = new MAHierarchyList();
		result.data = (Vector<PersistentMAHierarchy>)this.data.clone();
		return result;
	}


}


