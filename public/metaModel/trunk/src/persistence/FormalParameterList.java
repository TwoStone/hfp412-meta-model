package persistence;

import java.util.*;

public class FormalParameterList  extends FormalParameterSearchList{

	protected FormalParameterList() {
		super();
	}
	public Iterator<PersistentFormalParameter> iterator(PersistentListProxi<PersistentFormalParameter> listProxi) {
		return new PersistentListIterator<PersistentFormalParameter>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentFormalParameter entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected FormalParameterList copy() {
		FormalParameterList result = new FormalParameterList();
		result.data = (Vector<PersistentFormalParameter>)this.data.clone();
		return result;
	}


}


