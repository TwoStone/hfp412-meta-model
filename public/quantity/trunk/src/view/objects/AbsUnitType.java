
package view.objects;

import view.AbsUnitTypeView;
import view.AbsUnitView;
import view.ModelException;


/* Additional import section end */

public abstract class AbsUnitType extends ViewObject implements AbsUnitTypeView{
    
    protected AbsUnitView defaultUnit;
    protected String name;
    
    public AbsUnitType(AbsUnitView defaultUnit,String name,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.defaultUnit = defaultUnit;
        this.name = name;        
    }
    
    @Override
	public AbsUnitView getDefaultUnit() throws ModelException {
        return this.defaultUnit;
    }
    @Override
	public void setDefaultUnit(AbsUnitView newValue) throws ModelException {
        this.defaultUnit = newValue;
    }
    @Override
	public String getName() throws ModelException {
        return this.name;
    }
    @Override
	public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    
    
    @Override
	public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitView defaultUnit = this.getDefaultUnit();
        if (defaultUnit != null) {
            ((ViewProxi)defaultUnit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(defaultUnit.getClassId(), defaultUnit.getId())));
        }
        
    }
    @Override
	public void sortSetValuedFields() throws ModelException {
        
    }
    @Override
	public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitAbsUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
        if(this.getDefaultUnit() != null) index = index - 1;
        return null;
    }
    @Override
	public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultUnit() == null ? 0 : 1);
    }
    @Override
	public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDefaultUnit() == null ? true : false);
    }
    @Override
	public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultUnit() != null && this.getDefaultUnit().equals(child)) return result;
        if(this.getDefaultUnit() != null) result = result + 1;
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0 + (this.getDefaultUnit() == null ? 0 : 1);
    }
    @Override
	public int getRowCount(){
        return 0 
            + 1;
    }
    @Override
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
    
    @Override
	public boolean isRowEditable(int index){
        return true;
    }
    @Override
	public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    @Override
	public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
