package persistence;

import java.util.*;

public class MMeasurementTypeList {

	protected Vector<PersistentMMeasurementType> data; //List of proxies
	protected MMeasurementTypeList() {
		this.data = new Vector<PersistentMMeasurementType>();
	}
	public Iterator<PersistentMMeasurementType> iterator(PersistentListProxi<PersistentMMeasurementType> listProxi) {
		return new PersistentListIterator<PersistentMMeasurementType>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMMeasurementType entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MMeasurementTypeList copy() {
		MMeasurementTypeList result = new MMeasurementTypeList();
		result.data = (Vector<PersistentMMeasurementType>)this.data.clone();
		return result;
	}


}


