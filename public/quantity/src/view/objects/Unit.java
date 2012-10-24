
package view.objects;

import view.*;


/* Additional import section end */

public class Unit extends view.objects.AbsUnit implements UnitView{
    
    protected UnitTypeView unitType;
    
    public Unit(String name,UnitTypeView unitType,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.unitType = unitType;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public UnitTypeView getUnitType() throws ModelException {
        return this.unitType;
    }
    public void setUnitType(UnitTypeView newValue) throws ModelException {
        this.unitType = newValue;
    }
    
    public void accept(view.visitor.AbsUnitVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(view.visitor.AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        UnitTypeView unitType = this.getUnitType();
        if (unitType != null) {
            ((ViewProxi)unitType).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(unitType.getClassId(), unitType.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getUnitType() != null) return new UnitTypeUnitWrapper(this, originalIndex, (ViewRoot)this.getUnitType());
        if(this.getUnitType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnitType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getUnitType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getUnitType() != null && this.getUnitType().equals(child)) return result;
        if(this.getUnitType() != null) result = result + 1;
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Unit
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
