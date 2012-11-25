
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
        super(type,name,id, classId);
        this.myConversion = myConversion;        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    @Override
	public long getClassId() {
        return getTypeId();
    }
    
    @Override
	public ConversionView getMyConversion() throws ModelException {
        return this.myConversion;
    }
    
    @Override
	public void accept(AbsUnitVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    @Override
	public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    @Override
	public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    @Override
	public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    @Override
	public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    @Override
	public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    @Override
	public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    @Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    
    @Override
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
    @Override
	public void sortSetValuedFields() throws ModelException {
        
    }
    @Override
	public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeAbsUnitWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getMyConversion() != null) return new MyConversionUnitWrapper(this, originalIndex, (ViewRoot)this.getMyConversion());
        if(this.getMyConversion() != null) index = index - 1;
        return null;
    }
    @Override
	public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getMyConversion() == null ? 0 : 1);
    }
    @Override
	public boolean isLeaf() throws ModelException {
        return true 
            && (this.getType() == null ? true : false)
            && (this.getMyConversion() == null ? true : false);
    }
    @Override
	public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getMyConversion() != null && this.getMyConversion().equals(child)) return result;
        if(this.getMyConversion() != null) result = result + 1;
        return -1;
    }
    @Override
	public int getNameIndex() throws ModelException {
        return 0 + (this.getType() == null ? 0 : 1);
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
    @Override
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
