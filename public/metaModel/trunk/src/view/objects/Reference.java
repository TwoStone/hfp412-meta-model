
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Reference extends ViewObject implements ReferenceView{
    
    protected ReferenceTypeView type;
    protected long exponent;
    protected UnitView ref;
    
    public Reference(ReferenceTypeView type,long exponent,UnitView ref,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.type = type;
        this.exponent = exponent;
        this.ref = ref;        
    }
    
    static public long getTypeId() {
        return 180;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ReferenceTypeView getType() throws ModelException {
        return this.type;
    }
    public void setType(ReferenceTypeView newValue) throws ModelException {
        this.type = newValue;
    }
    public long getExponent() throws ModelException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws ModelException {
        this.exponent = newValue;
    }
    public UnitView getRef() throws ModelException {
        return this.ref;
    }
    public void setRef(UnitView newValue) throws ModelException {
        this.ref = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleReference(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReference(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        ReferenceTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        UnitView ref = this.getRef();
        if (ref != null) {
            ((ViewProxi)ref).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(ref.getClassId(), ref.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeReferenceWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getRef() != null) return new RefReferenceWrapper(this, originalIndex, (ViewRoot)this.getRef());
        if(this.getRef() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getRef() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false)
            && (this.getRef() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getRef() != null && this.getRef().equals(child)) return result;
        if(this.getRef() != null) result = result + 1;
        return -1;
    }
    public int getExponentIndex() throws ModelException {
        return 0 + (this.getType() == null ? 0 : 1);
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
