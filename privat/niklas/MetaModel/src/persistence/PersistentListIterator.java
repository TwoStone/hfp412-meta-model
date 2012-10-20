package persistence;

import java.util.Iterator;
import java.util.Collection;

public class PersistentListIterator<T extends AbstractPersistentRoot> implements Iterator<T> {

	Iterator<T> baseIterator;
	T current;
	PersistentListProxi<T> listProxi;

	public PersistentListIterator(PersistentListProxi<T> listProxi, Collection<T> data){
		this.listProxi = listProxi;
		this.baseIterator = data.iterator();
	}
	public boolean hasNext(){
		return this.baseIterator.hasNext();
	}
	public T next() {
		this.current = this.baseIterator.next();
		return current;
	}
	public void remove() {
		try {
			this.listProxi.remove((PersistentListEntryProxi) current);
		}catch (PersistenceException e) {
		  throw new PersistenceError(e);
		}
		this.baseIterator.remove();
	}
}