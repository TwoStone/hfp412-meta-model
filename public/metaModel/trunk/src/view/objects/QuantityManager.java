
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class QuantityManager extends ViewObject implements QuantityManagerView{
    
    protected java.util.Vector<AbsQuantityView> quantities;
    
    public QuantityManager(java.util.Vector<AbsQuantityView> quantities,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.quantities = quantities;        
    }
    
    static public long getTypeId() {
        return 170;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<AbsQuantityView> getQuantities() throws ModelException {
        return this.quantities;
    }
    public void setQuantities(java.util.Vector<AbsQuantityView> newValue) throws ModelException {
        this.quantities = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantityManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantityManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantityManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantityManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> quantities = this.getQuantities();
        if (quantities != null) {
            ViewObject.resolveVectorProxies(quantities, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getQuantities().size()) return new QuantitiesQuantityManagerWrapper(this, originalIndex, (ViewRoot)this.getQuantities().get(index));
        index = index - this.getQuantities().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getQuantities().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getQuantities().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getQuantitiesIterator = this.getQuantities().iterator();
        while(getQuantitiesIterator.hasNext()){
            if(getQuantitiesIterator.next().equals(child)) return result;
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
