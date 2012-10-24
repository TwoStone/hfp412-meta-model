
package view.objects;

import view.*;


/* Additional import section end */

public class UnitType extends view.objects.AbsUnitType implements UnitTypeView{
    
    protected UnitView defaultUnit;
    
    public UnitType(UnitView defaultUnit,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.defaultUnit = defaultUnit;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public UnitView getDefaultUnit() throws ModelException {
        return this.defaultUnit;
    }
    public void setDefaultUnit(UnitView newValue) throws ModelException {
        this.defaultUnit = newValue;
    }
    
    public void accept(view.visitor.AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(view.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        UnitView defaultUnit = this.getDefaultUnit();
        if (defaultUnit != null) {
            ((ViewProxi)defaultUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(defaultUnit.getClassId(), defaultUnit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
        if(this.getDefaultUnit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultUnit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDefaultUnit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultUnit() != null && this.getDefaultUnit().equals(child)) return result;
        if(this.getDefaultUnit() != null) result = result + 1;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class UnitType
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
