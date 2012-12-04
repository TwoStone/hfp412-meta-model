
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MSumType extends view.objects.MComplexType implements MSumTypeView{
    
    
    public MSumType(java.util.Vector<MType> containedTypes,String TypeLinkOperator,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(containedTypes,(String)TypeLinkOperator,id, classId);        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(MComplexTypeVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MTypeVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> containedTypes = this.getContainedTypes();
        if (containedTypes != null) {
            ViewObject.resolveVectorProxies(containedTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getContainedTypes().size()) return new ContainedTypesMComplexTypeWrapper(this, originalIndex, (ViewRoot)this.getContainedTypes().get(index));
        index = index - this.getContainedTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContainedTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getContainedTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getContainedTypesIterator = this.getContainedTypes().iterator();
        while(getContainedTypesIterator.hasNext()){
            if(getContainedTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getTypeLinkOperatorIndex() throws ModelException {
        return 0 + this.getContainedTypes().size();
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "TypeLinkOperator";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getTypeLinkOperator();
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