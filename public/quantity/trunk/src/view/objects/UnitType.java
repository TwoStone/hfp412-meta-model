
package view.objects;

import view.AbsUnitView;
import view.ModelException;
import view.UnitTypeView;
import view.UserException;
import view.visitor.AbsUnitTypeExceptionVisitor;
import view.visitor.AbsUnitTypeReturnExceptionVisitor;
import view.visitor.AbsUnitTypeReturnVisitor;
import view.visitor.AbsUnitTypeVisitor;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class UnitType extends view.objects.AbsUnitType implements UnitTypeView{
    
    
    public UnitType(AbsUnitView defaultUnit,String name,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AbsUnitView)defaultUnit,(String)name,id, classId);        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitType(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitView defaultUnit = this.getDefaultUnit();
        if (defaultUnit != null) {
            ((ViewProxi)defaultUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(defaultUnit.getClassId(), defaultUnit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitAbsUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
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
    public int getNameIndex() throws ModelException {
        return 0 + (this.getDefaultUnit() == null ? 0 : 1);
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
    
    @Override
	public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
