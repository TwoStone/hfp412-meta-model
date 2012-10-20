package persistence;

import java.util.*;

public class AkteurList  extends AkteurSearchList{

	protected AkteurList() {
		super();
	}
	public Iterator<PersistentAkteur> iterator(PersistentListProxi<PersistentAkteur> listProxi) {
		return new PersistentListIterator<PersistentAkteur>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAkteur entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AkteurList copy() {
		AkteurList result = new AkteurList();
		result.data = (Vector<PersistentAkteur>)this.data.clone();
		return result;
	}


}


