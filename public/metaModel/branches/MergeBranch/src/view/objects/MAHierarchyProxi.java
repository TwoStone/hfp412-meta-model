package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MAHierarchyProxi extends ViewProxi implements MAHierarchyView{
    
    public MAHierarchyProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MAHierarchyView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> associations_string = (java.util.Vector<String>)resultTable.get("associations");
        java.util.Vector<MAssociationView> associations = ViewProxi.getProxiVector(associations_string, connectionKey);
        MAHierarchyView result$$ = new MAHierarchy((String)name,associations, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAssociations().size()) return new AssociationsMAHierarchyWrapper(this, originalIndex, (ViewRoot)this.getAssociations().get(index));
        index = index - this.getAssociations().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAssociations().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAssociations().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAssociationsIterator = this.getAssociations().iterator();
        while(getAssociationsIterator.hasNext()){
            if(getAssociationsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName() throws ModelException {
        return ((MAHierarchy)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MAHierarchy)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<MAssociationView> getAssociations() throws ModelException {
        return ((MAHierarchy)this.getTheObject()).getAssociations();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAHierarchy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAHierarchy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAHierarchy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAHierarchy(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
