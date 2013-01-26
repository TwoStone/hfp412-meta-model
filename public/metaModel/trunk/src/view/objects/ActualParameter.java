
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ActualParameter extends ViewObject implements ActualParameterView{
    
    protected FormalParameterView type;
    protected InstanceObjectView value;
    
    public ActualParameter(FormalParameterView type,InstanceObjectView value,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.type = type;
        this.value = value;        
    }
    
    static public long getTypeId() {
        return 196;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public FormalParameterView getType() throws ModelException {
        return this.type;
    }
    public void setType(FormalParameterView newValue) throws ModelException {
        this.type = newValue;
    }
    public InstanceObjectView getValue() throws ModelException {
        return this.value;
    }
    public void setValue(InstanceObjectView newValue) throws ModelException {
        this.value = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleActualParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleActualParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleActualParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleActualParameter(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        FormalParameterView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        InstanceObjectView value = this.getValue();
        if (value != null) {
            ((ViewProxi)value).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(value.getClassId(), value.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeActualParameterWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getValue() != null) return new ValueActualParameterWrapper(this, originalIndex, (ViewRoot)this.getValue());
        if(this.getValue() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getValue() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false)
            && (this.getValue() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getValue() != null && this.getValue().equals(child)) return result;
        if(this.getValue() != null) result = result + 1;
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
