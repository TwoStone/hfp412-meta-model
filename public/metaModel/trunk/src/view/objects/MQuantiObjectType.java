
package view.objects;

import view.*;


/* Additional import section end */

public abstract class MQuantiObjectType extends ViewObject implements MQuantiObjectTypeView{
    
    protected MType type;
    protected AbsUnitTypeView unitType;
    
    public MQuantiObjectType(MType type,AbsUnitTypeView unitType,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.type = type;
        this.unitType = unitType;        
    }
    
    public MType getType() throws ModelException {
        return this.type;
    }
    public void setType(MType newValue) throws ModelException {
        this.type = newValue;
    }
    public AbsUnitTypeView getUnitType() throws ModelException {
        return this.unitType;
    }
    public void setUnitType(AbsUnitTypeView newValue) throws ModelException {
        this.unitType = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        MType type = this.getType();
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
