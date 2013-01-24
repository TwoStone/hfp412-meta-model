
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MMeasurementType extends view.objects.MQuantiObjectType implements MMeasurementTypeView{
    
    
    public MMeasurementType(MTypeView type,AbsUnitTypeView unitType,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((MTypeView)type,(AbsUnitTypeView)unitType,id, classId);        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws ModelException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMMeasurementType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMMeasurementType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        AbsUnitTypeView unitType = this.getUnitType();
        if (unitType != null) {
            ((ViewProxi)unitType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(unitType.getClassId(), unitType.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeMQuantiObjectTypeWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getUnitType() != null) return new UnitTypeMQuantiObjectTypeWrapper(this, originalIndex, (ViewRoot)this.getUnitType());
        if(this.getUnitType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getUnitType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false)
            && (this.getUnitType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getUnitType() != null && this.getUnitType().equals(child)) return result;
        if(this.getUnitType() != null) result = result + 1;
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