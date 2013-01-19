package persistence;

import java.util.*;

public class HierarchyList  extends HierarchySearchList{

	protected HierarchyList() {
		super();
	}
	public Iterator<PersistentHierarchy> iterator(PersistentListProxi<PersistentHierarchy> listProxi) {
		return new PersistentListIterator<PersistentHierarchy>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentHierarchy entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected HierarchyList copy() {
		HierarchyList result = new HierarchyList();
		result.data = (Vector<PersistentHierarchy>)this.data.clone();
		return result;
	}


}


