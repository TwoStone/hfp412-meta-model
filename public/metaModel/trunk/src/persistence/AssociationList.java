package persistence;

import java.util.*;

public class AssociationList  extends AssociationSearchList{

	protected AssociationList() {
		super();
	}
	public Iterator<PersistentAssociation> iterator(PersistentListProxi<PersistentAssociation> listProxi) {
		return new PersistentListIterator<PersistentAssociation>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAssociation entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AssociationList copy() {
		AssociationList result = new AssociationList();
		result.data = (Vector<PersistentAssociation>)this.data.clone();
		return result;
	}


}


