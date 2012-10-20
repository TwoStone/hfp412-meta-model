package persistence;

import java.util.*;

public class ProduktList {

	protected Vector<PersistentProdukt> data; //List of proxies
	protected ProduktList() {
		this.data = new Vector<PersistentProdukt>();
	}
	public Iterator<PersistentProdukt> iterator(PersistentListProxi<PersistentProdukt> listProxi) {
		return new PersistentListIterator<PersistentProdukt>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentProdukt entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ProduktList copy() {
		ProduktList result = new ProduktList();
		result.data = (Vector<PersistentProdukt>)this.data.clone();
		return result;
	}


}


