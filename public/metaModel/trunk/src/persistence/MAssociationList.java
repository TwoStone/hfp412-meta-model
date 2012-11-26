package persistence;

import java.util.*;

public class MAssociationList  extends MAssociationSearchList{

	protected MAssociationList() {
		super();
	}
	public Iterator<PersistentMAssociation> iterator(PersistentListProxi<PersistentMAssociation> listProxi) {
		return new PersistentListIterator<PersistentMAssociation>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMAssociation entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MAssociationList copy() {
		MAssociationList result = new MAssociationList();
		result.data = (Vector<PersistentMAssociation>)this.data.clone();
		return result;
	}


}


