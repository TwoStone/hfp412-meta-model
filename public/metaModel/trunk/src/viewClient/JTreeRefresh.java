package viewClient;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;

import view.ModelException;
import view.objects.IconRenderer;
import view.objects.ViewObjectInTree;
import view.objects.ViewProxi;
import view.objects.ViewRoot;

@SuppressWarnings("serial")
public class JTreeRefresh extends JTree{
	
	private boolean refreshing;
	public JTreeRefresh(){
		super();
		this.refreshing = false;
		this.setRootVisible(false);
		this.setModel(null);
		this.setExpandsSelectedPaths(true);
		this.setCellRenderer(new IconRenderer());
		this.setRowHeight(20);
		super.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent event) {
				javax.swing.tree.TreePath treePath = event.getNewLeadSelectionPath();
//				prepareNode(treePath);
				if (treePath != null){
					Object[] path = event.getNewLeadSelectionPath().getPath();
					if (path.length > 0)
						((view.objects.ViewRoot)getModel()).updateTreeView(new javax.swing.event.TreeModelEvent(path[path.length - 1],path));
				}
			}
		});
		this.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener(){
			public void treeCollapsed(TreeExpansionEvent event) {}
			public void treeExpanded(TreeExpansionEvent event) {
				Object[] path = event.getPath().getPath();
				((view.objects.ViewRoot)getModel()).updateTreeView(new javax.swing.event.TreeModelEvent(path[path.length - 1],path));
			}
		});
		this.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener(){
			public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
			}
			public void treeWillExpand(final TreeExpansionEvent event) throws ExpandVetoException {
				if (!prepareNode(event.getPath())) {					
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							TreePath path = event.getPath().getParentPath();
							collapsePath(path);
						}
					});
					throw new ExpandVetoException(event);
				}
			}
		});
	}
	public void addTreeSelectionListener(javax.swing.event.TreeSelectionListener listener){
		javax.swing.event.TreeSelectionListener[] currentListeners = this.getListeners(javax.swing.event.TreeSelectionListener.class);
		for (int i = 0; i < currentListeners.length; i++)this.removeTreeSelectionListener(currentListeners[i]);
		super.addTreeSelectionListener(listener);
		for (int i = 0; i < currentListeners.length; i++)super.addTreeSelectionListener(currentListeners[i]);
	}
	protected boolean prepareNode(TreePath path){
		if (path != null){
			Object lastComponent = path.getLastPathComponent();
			if (lastComponent != null){
				view.objects.ViewProxi toBeExpanded = (view.objects.ViewProxi)((view.objects.ViewObjectInTree) lastComponent).getWrappedObject();
				if (JTreeRefresh.this.refreshing) toBeExpanded.setExpanded(true);
				return toBeExpanded.expand();
			}
		}
		return false;
	}
	public void setModel(javax.swing.tree.TreeModel model){
		if (model instanceof view.objects.ViewProxi){
			view.objects.ViewProxi proxi = (ViewProxi) model;
			proxi.expand();
		}
		if (this.getModel() == null || model == null || !this.getModel().equals(model)) super.setModel(model);
	}
	
	public void refresh() throws ModelException {
		view.objects.ViewProxi model = (ViewProxi) this.getModel();
		Enumeration<TreePath> expandedPaths = null;
		TreePath[] selectedPaths = null;
		TreePath selectedPath = null;
		Vector<ViewRoot> visibleContext = new Vector<ViewRoot>();
		if(this.getModel() != null){
			expandedPaths = this.getExpandedDescendants(new TreePath(this.getModel().getRoot()));
			if (expandedPaths != null) {
				while (expandedPaths.hasMoreElements()){
					ViewRoot current = ((ViewObjectInTree) expandedPaths.nextElement().getLastPathComponent()).getWrappedObject();
					if (visibleContext.contains(current))continue;
					visibleContext.add(current);
				}
			}
			expandedPaths = this.getExpandedDescendants(new TreePath(this.getModel().getRoot()));
			selectedPaths =	this.getSelectionPaths();
			if (selectedPaths != null){
				for (int i = 0; i < selectedPaths.length; i++){
					ViewRoot current = ((ViewObjectInTree) selectedPaths[i].getLastPathComponent()).getWrappedObject();
					if (visibleContext.contains(current))continue;
					visibleContext.add(current);
				}
			}
			selectedPath = this.getSelectionPath();
			if (selectedPath != null){
				ViewRoot selectedObject = ((ViewObjectInTree) selectedPath.getLastPathComponent()).getWrappedObject();
				if (!visibleContext.contains(selectedObject)) visibleContext.add(selectedObject);				
			}
		}
		super.setModel(null);
		model.getRemote(visibleContext, true);
		super.setModel(model);
		this.refreshing = true;
		if(this.getModel() != null){
			if(expandedPaths!= null){
				Enumeration<TreePath> found = this.find(expandedPaths);
				while (expandedPaths.hasMoreElements())this.setExpandedState(expandedPaths.nextElement(), false);
				while (found.hasMoreElements())this.setExpandedState(found.nextElement(), true);
			}
			if(selectedPaths != null)this.setSelectionPaths(find(selectedPaths));
			if(selectedPath != null){
				TreePath selected = find(selectedPath);
				if(selected != null){
					if (selectedPaths != null) this.setLeadSelectionPath(selected);
					else this.setSelectionPath(selected);
				}
			}
		}
		this.refreshing = false;
	}
	private TreePath[] find(TreePath[] selectedPaths) {
		Vector<TreePath> foundPaths = new Vector<TreePath>();
		for (int i = 0; i < selectedPaths.length; i++){
			TreePath search = selectedPaths[i];
			TreePath found = find(search);
			if(found != null )foundPaths.add(found);
		}
		TreePath[] result = new TreePath[foundPaths.size()];
		int i = 0;
		for (TreePath current : foundPaths) result[i++] = current;
		return result;
	}
	private Enumeration<TreePath> find(Enumeration<TreePath> expandedPaths) {
		Vector<TreePath> foundPaths = new Vector<TreePath>();
		while (expandedPaths.hasMoreElements()){
			TreePath search = expandedPaths.nextElement();
			TreePath found = find(search);
			if(found != null && !foundPaths.contains(found))foundPaths.add(found);
		}
		return foundPaths.elements();
	}

	private TreePath find(TreePath current) {
		if(this.getModel() == null) return null;
		Object[]searched = current.getPath();
		Object[]found = new Object[searched.length];
		found[0] = this.getModel().getRoot();
		for (int i = 1; i < searched.length; i++){
			for (int j = 0; j < this.getModel().getChildCount(found[i - 1]); j++){
				Object currentChild = this.getModel().getChild(found[i - 1], j);
				if(currentChild.equals(searched[i])){
					found[i] = currentChild;
					break;
				}
			}
			if (found[i] == null) return null;
		}
		return new TreePath(found);
	}
	
	/**
	 * @return the currently selected object; returns null if nothing is selected
	 */
	public ViewRoot getSelectedObject(){
		ViewObjectInTree selectedWapper = this.getSelectedWrapper();
		if (selectedWapper != null) return selectedWapper.getWrappedObject();
		return null;
	}
	public ViewObjectInTree getSelectedWrapper(){
		TreePath selectedPath = this.getSelectionPath();
		if (selectedPath != null) {
			ViewObjectInTree selected = (ViewObjectInTree)selectedPath.getLastPathComponent();
			return selected;
		}
		return null;
	}

}
