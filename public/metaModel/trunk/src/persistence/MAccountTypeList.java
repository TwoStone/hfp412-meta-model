package persistence;

import java.util.*;

public class MAccountTypeList {

	protected Vector<PersistentMAccountType> data; //List of proxies
	protected MAccountTypeList() {
		this.data = new Vector<PersistentMAccountType>();
	}
	public Iterator<PersistentMAccountType> iterator(PersistentListProxi<PersistentMAccountType> listProxi) {
		return new PersistentListIterator<PersistentMAccountType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMAccountType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MAccountTypeList copy() {
		MAccountTypeList result = new MAccountTypeList();
		result.data = (Vector<PersistentMAccountType>)this.data.clone();
		return result;
	}


}


