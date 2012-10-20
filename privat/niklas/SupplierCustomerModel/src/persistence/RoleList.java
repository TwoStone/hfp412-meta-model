package persistence;

import java.util.*;

public class RoleList  extends RoleSearchList{

	protected RoleList() {
		super();
	}
	public Iterator<PersistentRole> iterator(PersistentListProxi<PersistentRole> listProxi) {
		return new PersistentListIterator<PersistentRole>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentRole entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected RoleList copy() {
		RoleList result = new RoleList();
		result.data = (Vector<PersistentRole>)this.data.clone();
		return result;
	}


}


