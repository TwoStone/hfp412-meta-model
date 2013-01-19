package persistence;

import java.util.*;

public class ActualParameterList  extends ActualParameterSearchList{

	protected ActualParameterList() {
		super();
	}
	public Iterator<PersistentActualParameter> iterator(PersistentListProxi<PersistentActualParameter> listProxi) {
		return new PersistentListIterator<PersistentActualParameter>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentActualParameter entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ActualParameterList copy() {
		ActualParameterList result = new ActualParameterList();
		result.data = (Vector<PersistentActualParameter>)this.data.clone();
		return result;
	}


}


