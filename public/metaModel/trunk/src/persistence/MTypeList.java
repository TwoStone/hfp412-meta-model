package persistence;

import java.util.*;

public class MTypeList  extends MTypeSearchList{

	protected MTypeList() {
		super();
	}
	public Iterator<PersistentMType> iterator(PersistentListProxi<PersistentMType> listProxi) {
		return new PersistentListIterator<PersistentMType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MTypeList copy() {
		MTypeList result = new MTypeList();
		result.data = (Vector<PersistentMType>)this.data.clone();
		return result;
	}


}


