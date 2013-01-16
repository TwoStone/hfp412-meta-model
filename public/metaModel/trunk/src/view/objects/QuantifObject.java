
package view.objects;

import view.*;


/* Additional import section end */

public abstract class QuantifObject extends ViewObject implements QuantifObjectView{
    
    protected InstanceObjectView object;
    
    public QuantifObject(InstanceObjectView object,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.object = object;        
    }
    
    public InstanceObjectView getObject() throws ModelException {
        return this.object;
    }
    public void setObject(InstanceObjectView newValue) throws ModelException {
        this.object = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        InstanceObjectView object = this.getObject();
        if (object != null) {
            ((ViewProxi)object).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(object.getClassId(), object.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getObject() != null) return new ObjectQuantifObjectWrapper(this, originalIndex, (ViewRoot)this.getObject());
        if(this.getObject() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getObject() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getObject() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getObject() != null && this.getObject().equals(child)) return result;
        if(this.getObject() != null) result = result + 1;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
