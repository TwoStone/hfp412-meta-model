package persistence;

import java.util.*;

public class CommandExecuterList {

	protected Vector<PersistentCommandExecuter> data; //List of proxies
	protected CommandExecuterList() {
		this.data = new Vector<PersistentCommandExecuter>();
	}
	public Iterator<PersistentCommandExecuter> iterator(PersistentListProxi<PersistentCommandExecuter> listProxi) {
		return new PersistentListIterator<PersistentCommandExecuter>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentCommandExecuter entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected CommandExecuterList copy() {
		CommandExecuterList result = new CommandExecuterList();
		result.data = (Vector<PersistentCommandExecuter>)this.data.clone();
		return result;
	}


}


