
package view.objects;

import view.*;


/* Additional import section end */

public abstract class QuantifObject extends ViewObject implements QuantifObjectView{
    
    protected InstanceObjectView defaultType;
    
    public QuantifObject(InstanceObjectView defaultType,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.defaultType = defaultType;        
    }
    
    public InstanceObjectView getDefaultType() throws ModelException {
        return this.defaultType;
    }
    public void setDefaultType(InstanceObjectView newValue) throws ModelException {
        this.defaultType = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        InstanceObjectView defaultType = this.getDefaultType();
        if (defaultType != null) {
            ((ViewProxi)defaultType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(defaultType.getClassId(), defaultType.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultType() != null) return new DefaultTypeQuantifObjectWrapper(this, originalIndex, (ViewRoot)this.getDefaultType());
        if(this.getDefaultType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDefaultType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultType() != null && this.getDefaultType().equals(child)) return result;
        if(this.getDefaultType() != null) result = result + 1;
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
