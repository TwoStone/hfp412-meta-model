package view.objects;

import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;

import view.*;

public abstract class ViewRoot extends ViewObjectInTree implements TableModel, TreeModel {

	public static final String DATEFORMAT = "dd.MM.yyyy";
	public static final String TIMESTAMPFORMAT = "dd.MM.yyyy HH:mm:ss";
	
	private static final String ValueColumnName = "Value";
	private static final String FieldColumnName = "Field";

	public static String toString(java.util.Date date, boolean doWithMillies) {
		if( doWithMillies ){
			return new java.text.SimpleDateFormat(TIMESTAMPFORMAT).format(date, new StringBuffer(),new java.text.FieldPosition(0)).toString();
		}else {
			return new java.text.SimpleDateFormat(DATEFORMAT).format(date, new StringBuffer(),new java.text.FieldPosition(0)).toString();
		}
	}
	
	protected static final long UndefinedObjectId = -1;

	protected static final long UndefinedClassId = 0;

	
	private long id;
	private long classId;
	protected String toString;
	
	private int iconInfo;
	private int leafInfo;

	int getIconInfo() {
		return iconInfo;
	}
	void setIconInfo(int iconInfo) {
		this.iconInfo = iconInfo;
	}
	int getLeafInfo() {
		return leafInfo;
	}
	void setLeafInfo(int leafInfo) {
		this.leafInfo = leafInfo;
	}
	

	public ViewRoot(long id, long classId) {
		this.id = id;
		this.classId = classId;
	}

	public long getId() {
		return this.id;
	}

	public long getClassId() {
		return this.classId;
	}

  	public void setToString(String toString) {
	  	this.toString = toString;
  	}
  	
	public boolean equals(Object object) {
		if (object == null) return false;
		if (object instanceof ViewObjectInTree){
			ViewRoot argument = ((ViewObjectInTree)object).getWrappedObject();
			return this.id == argument.id && this.getClassId() == argument.getClassId();
		}else{
			return false;
		}
	}
	public boolean isUndefined() {
		return this.getId() <= 0;
	}
	public abstract ViewObject getTheObject() throws ModelException;

	public ViewRoot getWrappedObject() {
		return this;
	}
	    public Object getChild(Object object, int index) {
        try {
            return ((ViewObjectInTree)object).getChild(index);
        } catch (ModelException e){
            return e.getMessage();
        }
    }

	private javax.swing.event.EventListenerList treeModelListeners;

	private javax.swing.event.EventListenerList getTreeModelListeners() {
		if (this.treeModelListeners == null)
			this.treeModelListeners = new javax.swing.event.EventListenerList();
		return this.treeModelListeners;
	}

	public void addTreeModelListener(javax.swing.event.TreeModelListener l) {
		this.getTreeModelListeners().add(javax.swing.event.TreeModelListener.class, l);
	}

	public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {
		this.getTreeModelListeners().remove(javax.swing.event.TreeModelListener.class, l);
	}
	public void updateTreeView(javax.swing.event.TreeModelEvent e) {
		javax.swing.event.TreeModelListener[] l = (javax.swing.event.TreeModelListener[]) this.getTreeModelListeners().getListeners(javax.swing.event.TreeModelListener.class);
		for (int i = 0; i < l.length; i++) l[i].treeNodesChanged(e);
	}

    public int getChildCount(Object object) {
        try {
            return ((ViewObjectInTree)object).getChildCount();
        } catch (ModelException e){
            return 0;
        }
    }
    public boolean isLeaf(Object object) {
        try {
            return ((ViewObjectInTree)object).isLeaf();
        } catch (ModelException e){
            return true;
        }
    }
    public int getIndexOfChild(Object object, Object child) {
        try {
            return ((ViewObjectInTree)object).getIndexOfChild(child);
        } catch (ModelException e){
            return 0;
        }
    }
	public ViewRoot getRoot() {
		return this;
	}
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	public int getColumnCount() {
		return 2;
	}
	public String getColumnName(int columnIndex) {
		return (columnIndex == 0 ? FieldColumnName : ValueColumnName);
	}
	public int getRemoteDepth(){
		return 1;
	}
	public abstract boolean hasTransientFields();
	
	public void setIcon(IconRenderer renderer) {
		renderer.setIcon(viewClient.IconManager.getIcon(this.getIconInfo()));
	}	
}
