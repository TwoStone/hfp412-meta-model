package persistence;

import java.util.*;

public class MFormalParameterList  extends MFormalParameterSearchList{

	protected MFormalParameterList() {
		super();
	}
	public Iterator<PersistentMFormalParameter> iterator(PersistentListProxi<PersistentMFormalParameter> listProxi) {
		return new PersistentListIterator<PersistentMFormalParameter>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMFormalParameter entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MFormalParameterList copy() {
		MFormalParameterList result = new MFormalParameterList();
		result.data = (Vector<PersistentMFormalParameter>)this.data.clone();
		return result;
	}


}


