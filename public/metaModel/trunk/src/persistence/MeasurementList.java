package persistence;

import java.util.*;

public class MeasurementList {

	protected Vector<PersistentMeasurement> data; //List of proxies
	protected MeasurementList() {
		this.data = new Vector<PersistentMeasurement>();
	}
	public Iterator<PersistentMeasurement> iterator(PersistentListProxi<PersistentMeasurement> listProxi) {
		return new PersistentListIterator<PersistentMeasurement>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMeasurement entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MeasurementList copy() {
		MeasurementList result = new MeasurementList();
		result.data = (Vector<PersistentMeasurement>)this.data.clone();
		return result;
	}


}


