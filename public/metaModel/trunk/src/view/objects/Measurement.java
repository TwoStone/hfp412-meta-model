
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Measurement extends ViewObject implements MeasurementView{
    
    protected MMeasurementTypeView type;
    protected AbsQuantityView quantity;
    
    public Measurement(MMeasurementTypeView type,AbsQuantityView quantity,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.type = type;
        this.quantity = quantity;        
    }
    
    static public long getTypeId() {
        return 195;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MMeasurementTypeView getType() throws ModelException {
        return this.type;
    }
    public void setType(MMeasurementTypeView newValue) throws ModelException {
        this.type = newValue;
    }
    public AbsQuantityView getQuantity() throws ModelException {
        return this.quantity;
    }
    public void setQuantity(AbsQuantityView newValue) throws ModelException {
        this.quantity = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMeasurement(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMeasurement(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMeasurement(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMeasurement(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MMeasurementTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        AbsQuantityView quantity = this.getQuantity();
        if (quantity != null) {
            ((ViewProxi)quantity).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(quantity.getClassId(), quantity.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeMeasurementWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getQuantity() != null) return new QuantityMeasurementWrapper(this, originalIndex, (ViewRoot)this.getQuantity());
        if(this.getQuantity() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getQuantity() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false)
            && (this.getQuantity() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getQuantity() != null && this.getQuantity().equals(child)) return result;
        if(this.getQuantity() != null) result = result + 1;
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
