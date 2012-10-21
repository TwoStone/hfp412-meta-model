package persistence;

import java.util.*;

public class CommandList {

	protected Vector<Command> data; //List of proxies
	protected CommandList() {
		this.data = new Vector<Command>();
	}
	public Iterator<Command> iterator(PersistentListProxi<Command> listProxi) {
		return new PersistentListIterator<Command>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Command entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected CommandList copy() {
		CommandList result = new CommandList();
		result.data = (Vector<Command>)this.data.clone();
		return result;
	}


}


