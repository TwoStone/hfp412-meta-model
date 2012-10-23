package persistence;

import java.util.*;

public class MetaTypeList  extends MetaTypeSearchList{

	protected MetaTypeList() {
		super();
	}
	public Iterator<PersistentMetaType> iterator(PersistentListProxi<PersistentMetaType> listProxi) {
		return new PersistentListIterator<PersistentMetaType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMetaType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MetaTypeList copy() {
		MetaTypeList result = new MetaTypeList();
		result.data = (Vector<PersistentMetaType>)this.data.clone();
		return result;
	}


}


