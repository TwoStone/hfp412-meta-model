
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ObjectManager extends ViewObject implements ObjectManagerView{
    
    protected java.util.Vector<MObjectView> objects;
    
    public ObjectManager(java.util.Vector<MObjectView> objects,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.objects = objects;        
    }
    
    static public long getTypeId() {
        return 237;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MObjectView> getObjects() throws ModelException {
        return this.objects;
    }
    public void setObjects(java.util.Vector<MObjectView> newValue) throws ModelException {
        this.objects = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleObjectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleObjectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleObjectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleObjectManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> objects = this.getObjects();
        if (objects != null) {
            ViewObject.resolveVectorProxies(objects, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getObjects().size()) return new ObjectsObjectManagerWrapper(this, originalIndex, (ViewRoot)this.getObjects().get(index));
        index = index - this.getObjects().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getObjects().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getObjects().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getObjectsIterator = this.getObjects().iterator();
        while(getObjectsIterator.hasNext()){
            if(getObjectsIterator.next().equals(child)) return result;
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
