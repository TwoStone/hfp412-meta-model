package persistence;

import java.util.*;

public class AbsUnitList  extends AbsUnitSearchList{

	protected AbsUnitList() {
		super();
	}
	public Iterator<PersistentAbsUnit> iterator(PersistentListProxi<PersistentAbsUnit> listProxi) {
		return new PersistentListIterator<PersistentAbsUnit>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAbsUnit entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AbsUnitList copy() {
		AbsUnitList result = new AbsUnitList();
		result.data = (Vector<PersistentAbsUnit>)this.data.clone();
		return result;
	}


}


