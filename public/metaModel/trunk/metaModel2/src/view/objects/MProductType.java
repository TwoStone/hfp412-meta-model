
package view.objects;

import view.*;


/* Additional import section end */

public class MProductType extends view.objects.MComplexType implements MProductTypeView{
    
    
    public MProductType(java.util.Vector<MType> containedTypes,String TypeLinkOperator,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(containedTypes,(String)TypeLinkOperator,id, classId);        
    }
    
    static public long getTypeId() {
        return 138;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(view.visitor.MComplexTypeVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.MComplexTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(view.visitor.MTypeVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MProductType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
