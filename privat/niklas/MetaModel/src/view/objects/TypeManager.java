
package view.objects;

import view.*;


/* Additional import section end */

public class TypeManager extends ViewObject implements TypeManagerView{
    
    protected java.util.Vector<AbstractMetaTypeView> allTypes;
    
    public TypeManager(java.util.Vector<AbstractMetaTypeView> allTypes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.allTypes = allTypes;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<AbstractMetaTypeView> getAllTypes() throws ModelException {
        return this.allTypes;
    }
    public void setAllTypes(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException {
        this.allTypes = newValue;
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeManager(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> allTypes = this.getAllTypes();
        if (allTypes != null) {
            ViewObject.resolveVectorProxies(allTypes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAllTypes().size()) return new AllTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAllTypes().get(index));
        index = index - this.getAllTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAllTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAllTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAllTypesIterator = this.getAllTypes().iterator();
        while(getAllTypesIterator.hasNext()){
            if(getAllTypesIterator.next().equals(child)) return result;
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
