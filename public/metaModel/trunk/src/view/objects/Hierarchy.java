
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Hierarchy extends ViewObject implements HierarchyView{
    
    protected String name;
    protected java.util.Vector<AssociationView> associations;
    
    public Hierarchy(String name,java.util.Vector<AssociationView> associations,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.associations = associations;        
    }
    
    static public long getTypeId() {
        return 163;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<AssociationView> getAssociations() throws ModelException {
        return this.associations;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleHierarchy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleHierarchy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleHierarchy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleHierarchy(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> associations = this.getAssociations();
        if (associations != null) {
            ViewObject.resolveVectorProxies(associations, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAssociations().size()) return new AssociationsHierarchyWrapper(this, originalIndex, (ViewRoot)this.getAssociations().get(index));
        index = index - this.getAssociations().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAssociations().size());
    }
    public boolean isLeaf() throws ModelException {
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
