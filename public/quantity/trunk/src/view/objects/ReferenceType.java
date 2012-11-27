
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ReferenceType extends ViewObject implements ReferenceTypeView{
    
    protected long exponent;
    protected UnitTypeView ref;
    
    public ReferenceType(long exponent,UnitTypeView ref,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.exponent = exponent;
        this.ref = ref;        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getExponent() throws ModelException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws ModelException {
        this.exponent = newValue;
    }
    public UnitTypeView getRef() throws ModelException {
        return this.ref;
    }
    public void setRef(UnitTypeView newValue) throws ModelException {
        this.ref = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleReferenceType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReferenceType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReferenceType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReferenceType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        UnitTypeView ref = this.getRef();
        if (ref != null) {
            ((ViewProxi)ref).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(ref.getClassId(), ref.getId())));
        }
        
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
    public int getExponentIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "exponent";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getExponent());
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
            this.setExponent(Long.parseLong(newValue));
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
