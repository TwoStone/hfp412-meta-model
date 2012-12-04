
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class AssociationManager extends ViewObject implements AssociationManagerView{
    
    protected java.util.Vector<MAssociationView> associations;
    protected java.util.Vector<MAHierarchyView> hierarchies;
    
    public AssociationManager(java.util.Vector<MAssociationView> associations,java.util.Vector<MAHierarchyView> hierarchies,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.associations = associations;
        this.hierarchies = hierarchies;        
    }
    
    static public long getTypeId() {
        return 141;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MAssociationView> getAssociations() throws ModelException {
        return this.associations;
    }
    public void setAssociations(java.util.Vector<MAssociationView> newValue) throws ModelException {
        this.associations = newValue;
    }
    public java.util.Vector<MAHierarchyView> getHierarchies() throws ModelException {
        return this.hierarchies;
    }
    public void setHierarchies(java.util.Vector<MAHierarchyView> newValue) throws ModelException {
        this.hierarchies = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> associations = this.getAssociations();
        if (associations != null) {
            ViewObject.resolveVectorProxies(associations, resultTable);
        }
        java.util.Vector<?> hierarchies = this.getHierarchies();
        if (hierarchies != null) {
            ViewObject.resolveVectorProxies(hierarchies, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}