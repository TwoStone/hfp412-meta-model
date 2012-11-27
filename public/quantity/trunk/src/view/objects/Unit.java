
package view.objects;

import view.AbsUnitTypeView;
import view.ConversionView;
import view.ModelException;
import view.UnitView;
import view.UserException;
import view.visitor.AbsUnitExceptionVisitor;
import view.visitor.AbsUnitReturnExceptionVisitor;
import view.visitor.AbsUnitReturnVisitor;
import view.visitor.AbsUnitVisitor;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Unit extends view.objects.AbsUnit implements UnitView{
    
    protected ConversionView myConversion;
    
    public Unit(AbsUnitTypeView type,String name,ConversionView myConversion,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AbsUnitTypeView)type,(String)name,id, classId);
        this.myConversion = myConversion;        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ConversionView getMyConversion() throws ModelException {
        return this.myConversion;
    }
    
    public void accept(AbsUnitVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        AbsUnitTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        ConversionView myConversion = this.getMyConversion();
        if (myConversion != null) {
            ((ViewProxi)myConversion).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myConversion.getClassId(), myConversion.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getMyConversion() != null) return new MyConversionUnitWrapper(this, originalIndex, (ViewRoot)this.getMyConversion());
        if(this.getMyConversion() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMyConversion() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMyConversion() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMyConversion() != null && this.getMyConversion().equals(child)) return result;
        if(this.getMyConversion() != null) result = result + 1;
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    @Override
	public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
