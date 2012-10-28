
package view.objects;

import view.*;


/* Additional import section end */

public class ComposedQuantity extends view.objects.AbsQuantity implements ComposedQuantityView{
    
    protected java.util.Vector<QuantityView> parts;
    
    public ComposedQuantity(java.util.Vector<QuantityView> parts,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.parts = parts;        
    }
    
    static public long getTypeId() {
        return 123;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<QuantityView> getParts() throws ModelException {
        return this.parts;
    }
    public void setParts(java.util.Vector<QuantityView> newValue) throws ModelException {
        this.parts = newValue;
    }
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComposedQuantity(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComposedQuantity(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> parts = this.getParts();
        if (parts != null) {
            ViewObject.resolveVectorProxies(parts, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsComposedQuantityWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
        index = index - this.getParts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getParts().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getParts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPartsIterator = this.getParts().iterator();
        while(getPartsIterator.hasNext()){
            if(getPartsIterator.next().equals(child)) return result;
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
            //TODO: implement setIcon in view class ComposedQuantity
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
