
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class FormalParameter extends ViewObject implements FormalParameterView{
    
    protected MTypeView ofType;
    protected String name;
    
    public FormalParameter(MTypeView ofType,String name,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.ofType = ofType;
        this.name = name;        
    }
    
    static public long getTypeId() {
        return 225;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MTypeView getOfType() throws ModelException {
        return this.ofType;
    }
    public void setOfType(MTypeView newValue) throws ModelException {
        this.ofType = newValue;
    }
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFormalParameter(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MTypeView ofType = this.getOfType();
        if (ofType != null) {
            ((ViewProxi)ofType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(ofType.getClassId(), ofType.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getOfType() != null) return new OfTypeFormalParameterWrapper(this, originalIndex, (ViewRoot)this.getOfType());
        if(this.getOfType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOfType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getOfType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOfType() != null && this.getOfType().equals(child)) return result;
        if(this.getOfType() != null) result = result + 1;
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0 + (this.getOfType() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
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
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
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
