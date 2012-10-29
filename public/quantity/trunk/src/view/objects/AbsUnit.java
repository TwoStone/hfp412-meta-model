
package view.objects;

import view.*;


/* Additional import section end */

public abstract class AbsUnit extends ViewObject implements AbsUnitView{
    
    protected AbsUnitTypeView type;
    protected String name;
    
    public AbsUnit(AbsUnitTypeView type,String name,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.type = type;
        this.name = name;        
    }
    
    public AbsUnitTypeView getType() throws ModelException {
        return this.type;
    }
    public void setType(AbsUnitTypeView newValue) throws ModelException {
        this.type = newValue;
    }
    public String getName() throws ModelException {
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeAbsUnitWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0 + (this.getType() == null ? 0 : 1);
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AbsUnit
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
