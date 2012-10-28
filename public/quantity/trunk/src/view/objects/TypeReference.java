
package view.objects;

import view.*;


/* Additional import section end */

public class TypeReference extends view.objects.AbsUnitType implements TypeReferenceView{
    
    
    public TypeReference(long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(view.visitor.AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(view.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeReference(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeReference(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
            //TODO: implement setIcon in view class TypeReference
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
