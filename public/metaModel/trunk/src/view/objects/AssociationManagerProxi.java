package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AssociationManagerProxi extends ViewProxi implements AssociationManagerView{
    
    public AssociationManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AssociationManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> associations_string = (java.util.Vector<String>)resultTable.get("associations");
        java.util.Vector<AssociationView> associations = ViewProxi.getProxiVector(associations_string, connectionKey);
        java.util.Vector<String> hierarchies_string = (java.util.Vector<String>)resultTable.get("hierarchies");
        java.util.Vector<HierarchyView> hierarchies = ViewProxi.getProxiVector(hierarchies_string, connectionKey);
        AssociationManagerView result$$ = new AssociationManager(associations,hierarchies, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAssociations().size()) return new AssociationsAssociationManagerWrapper(this, originalIndex, (ViewRoot)this.getAssociations().get(index));
        index = index - this.getAssociations().size();
        if(index < this.getHierarchies().size()) return new HierarchiesAssociationManagerWrapper(this, originalIndex, (ViewRoot)this.getHierarchies().get(index));
        index = index - this.getHierarchies().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAssociations().size())
            + (this.getHierarchies().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAssociations().size() == 0)
            && (this.getHierarchies().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAssociationsIterator = this.getAssociations().iterator();
        while(getAssociationsIterator.hasNext()){
            if(getAssociationsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getHierarchiesIterator = this.getHierarchies().iterator();
        while(getHierarchiesIterator.hasNext()){
            if(getHierarchiesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AssociationView> getAssociations() throws ModelException {
        return ((AssociationManager)this.getTheObject()).getAssociations();
    }
    public void setAssociations(java.util.Vector<AssociationView> newValue) throws ModelException {
        ((AssociationManager)this.getTheObject()).setAssociations(newValue);
    }
    public java.util.Vector<HierarchyView> getHierarchies() throws ModelException {
        return ((AssociationManager)this.getTheObject()).getHierarchies();
    }
    public void setHierarchies(java.util.Vector<HierarchyView> newValue) throws ModelException {
        ((AssociationManager)this.getTheObject()).setHierarchies(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAssociationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAssociationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAssociationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAssociationManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
