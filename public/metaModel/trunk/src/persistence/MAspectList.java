package persistence;

import java.util.*;

public class MAspectList  extends MAspectSearchList{

	protected MAspectList() {
		super();
	}
	public Iterator<PersistentMAspect> iterator(PersistentListProxi<PersistentMAspect> listProxi) {
		return new PersistentListIterator<PersistentMAspect>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMAspect entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MAspectList copy() {
		MAspectList result = new MAspectList();
		result.data = (Vector<PersistentMAspect>)this.data.clone();
		return result;
	}


}


