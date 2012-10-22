package persistence;

import java.util.*;

public class PositionList  extends PositionSearchList{

	protected PositionList() {
		super();
	}
	public Iterator<PersistentPosition> iterator(PersistentListProxi<PersistentPosition> listProxi) {
		return new PersistentListIterator<PersistentPosition>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentPosition entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected PositionList copy() {
		PositionList result = new PositionList();
		result.data = (Vector<PersistentPosition>)this.data.clone();
		return result;
	}


}


