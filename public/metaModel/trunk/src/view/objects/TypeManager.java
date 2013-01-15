
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class TypeManager extends ViewObject implements TypeManagerView{
    
    protected java.util.Vector<MTypeView> types;
    
    public TypeManager(java.util.Vector<MTypeView> types,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.types = types;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MTypeView> getTypes() throws ModelException {
        return this.types;
    }
    public void setTypes(java.util.Vector<MTypeView> newValue) throws ModelException {
        this.types = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> types = this.getTypes();
        if (types != null) {
            ViewObject.resolveVectorProxies(types, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getTypes().size()) return new TypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getTypes().get(index));
        index = index - this.getTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTypesIterator = this.getTypes().iterator();
        while(getTypesIterator.hasNext()){
            if(getTypesIterator.next().equals(child)) return result;
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
