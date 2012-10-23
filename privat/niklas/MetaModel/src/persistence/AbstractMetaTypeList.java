package persistence;

import java.util.*;

public class AbstractMetaTypeList  extends AbstractMetaTypeSearchList{

	protected AbstractMetaTypeList() {
		super();
	}
	public Iterator<PersistentAbstractMetaType> iterator(PersistentListProxi<PersistentAbstractMetaType> listProxi) {
		return new PersistentListIterator<PersistentAbstractMetaType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAbstractMetaType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AbstractMetaTypeList copy() {
		AbstractMetaTypeList result = new AbstractMetaTypeList();
		result.data = (Vector<PersistentAbstractMetaType>)this.data.clone();
		return result;
	}


}


