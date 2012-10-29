
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class TypeManager extends ViewObject implements TypeManagerView{
    
    protected java.util.Vector<MAtomicTypeView> atomicTypes;
    protected java.util.Vector<MProductTypeView> productTypes;
    protected java.util.Vector<MSumTypeView> sumTypes;
    
    public TypeManager(java.util.Vector<MAtomicTypeView> atomicTypes,java.util.Vector<MProductTypeView> productTypes,java.util.Vector<MSumTypeView> sumTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.atomicTypes = atomicTypes;
        this.productTypes = productTypes;
        this.sumTypes = sumTypes;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MAtomicTypeView> getAtomicTypes() throws ModelException {
        return this.atomicTypes;
    }
    public void setAtomicTypes(java.util.Vector<MAtomicTypeView> newValue) throws ModelException {
        this.atomicTypes = newValue;
    }
    public java.util.Vector<MProductTypeView> getProductTypes() throws ModelException {
        return this.productTypes;
    }
    public void setProductTypes(java.util.Vector<MProductTypeView> newValue) throws ModelException {
        this.productTypes = newValue;
    }
    public java.util.Vector<MSumTypeView> getSumTypes() throws ModelException {
        return this.sumTypes;
    }
    public void setSumTypes(java.util.Vector<MSumTypeView> newValue) throws ModelException {
        this.sumTypes = newValue;
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
        java.util.Vector<?> atomicTypes = this.getAtomicTypes();
        if (atomicTypes != null) {
            ViewObject.resolveVectorProxies(atomicTypes, resultTable);
        }
        java.util.Vector<?> productTypes = this.getProductTypes();
        if (productTypes != null) {
            ViewObject.resolveVectorProxies(productTypes, resultTable);
        }
        java.util.Vector<?> sumTypes = this.getSumTypes();
        if (sumTypes != null) {
            ViewObject.resolveVectorProxies(sumTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAtomicTypes().size()) return new AtomicTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAtomicTypes().get(index));
        index = index - this.getAtomicTypes().size();
        if(index < this.getProductTypes().size()) return new ProductTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getProductTypes().get(index));
        index = index - this.getProductTypes().size();
        if(index < this.getSumTypes().size()) return new SumTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getSumTypes().get(index));
        index = index - this.getSumTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAtomicTypes().size())
            + (this.getProductTypes().size())
            + (this.getSumTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAtomicTypes().size() == 0)
            && (this.getProductTypes().size() == 0)
            && (this.getSumTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAtomicTypesIterator = this.getAtomicTypes().iterator();
        while(getAtomicTypesIterator.hasNext()){
            if(getAtomicTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getProductTypesIterator = this.getProductTypes().iterator();
        while(getProductTypesIterator.hasNext()){
            if(getProductTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getSumTypesIterator = this.getSumTypes().iterator();
        while(getSumTypesIterator.hasNext()){
            if(getSumTypesIterator.next().equals(child)) return result;
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
