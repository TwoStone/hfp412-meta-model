
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class TypeManager extends ViewObject implements TypeManagerView{
    
    protected java.util.Vector<AbsUnitTypeView> unitTypes;
    
    public TypeManager(java.util.Vector<AbsUnitTypeView> unitTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.unitTypes = unitTypes;        
    }
    
    static public long getTypeId() {
        return 101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<AbsUnitTypeView> getUnitTypes() throws ModelException {
        return this.unitTypes;
    }
    public void setUnitTypes(java.util.Vector<AbsUnitTypeView> newValue) throws ModelException {
        this.unitTypes = newValue;
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
        java.util.Vector<?> unitTypes = this.getUnitTypes();
        if (unitTypes != null) {
            ViewObject.resolveVectorProxies(unitTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getUnitTypes().size()) return new UnitTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypes().get(index));
        index = index - this.getUnitTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnitTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getUnitTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitTypesIterator = this.getUnitTypes().iterator();
        while(getUnitTypesIterator.hasNext()){
            if(getUnitTypesIterator.next().equals(child)) return result;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class TypeManager
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
