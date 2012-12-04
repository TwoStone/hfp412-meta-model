package persistence;

import java.util.*;

public class ConversionList  extends ConversionSearchList{

	protected ConversionList() {
		super();
	}
	public Iterator<PersistentConversion> iterator(PersistentListProxi<PersistentConversion> listProxi) {
		return new PersistentListIterator<PersistentConversion>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentConversion entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ConversionList copy() {
		ConversionList result = new ConversionList();
		result.data = (Vector<PersistentConversion>)this.data.clone();
		return result;
	}


}


