package view.objects;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import view.*;

public abstract class ViewObject extends ViewRoot {

	public ViewObject(long id, long classId) {
		super(id, classId);
	}

	public ViewObject getTheObject() throws ModelException {
		return this;
	}


	public void valueForPathChanged(javax.swing.tree.TreePath path, Object newValue) {
		// TODO specialize this operation for the individual classes!
	}

	private EventListenerList tabelModelListeners;

	private EventListenerList getTabelModelListeners() {
		if (this.tabelModelListeners == null)
			this.tabelModelListeners = new EventListenerList();
		return this.tabelModelListeners;
	}

	public void addTableModelListener(TableModelListener l) {
		this.getTabelModelListeners().add(TableModelListener.class, l);
	}

	public void removeTableModelListener(TableModelListener l) {
		this.getTabelModelListeners().remove(TableModelListener.class, l);
	}
	public abstract int getRowCount();

	public abstract Object getValueAt(int rowIndex, int columnIndex);

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return false;
		return this.isRowEditable(rowIndex);
	}

	protected abstract boolean isRowEditable(int rowIndex);

	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
		try {
			this.setValueAt((String) newValue, rowIndex);
		} catch (Exception e) {
			return;
		}
		Object[] listeners = this.getTabelModelListeners().getListenerList();
		/*
		 * Process the listeners last to first, notifying / those that are
		 * interested in this event
		 */
		for (int i = listeners.length - 2; i >= 0; i -= 2)
			((TableModelListener) listeners[i + 1]).tableChanged(new TableModelEvent(this, rowIndex));
	}

	protected abstract void setValueAt(String string, int rowIndex) throws Exception;

	public abstract void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException;

	public static void resolveVectorProxies(java.util.Vector<?> v, java.util.Hashtable<String, Object> resultTable) {
		java.util.Iterator<?> entries = v.iterator();
		while (entries.hasNext()){
			ViewProxi current = (ViewProxi) entries.next();
			if (current != null)
				current.setObject((ViewObject) resultTable.get(common.RPCConstantsAndServices.createHashtableKey(current.getClassId(), current.getId())));
		}
	}
	
	abstract public void sortSetValuedFields() throws ModelException ;
	
	public String toString(){
		return this.toString;
	}

}