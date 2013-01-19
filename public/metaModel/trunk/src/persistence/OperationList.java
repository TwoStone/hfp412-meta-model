package persistence;

import java.util.*;

public class OperationList  extends OperationSearchList{

	protected OperationList() {
		super();
	}
	public Iterator<PersistentOperation> iterator(PersistentListProxi<PersistentOperation> listProxi) {
		return new PersistentListIterator<PersistentOperation>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentOperation entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected OperationList copy() {
		OperationList result = new OperationList();
		result.data = (Vector<PersistentOperation>)this.data.clone();
		return result;
	}


}


