
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Function extends ViewObject implements FunctionView{
    
    protected common.Fraction factor;
    protected common.Fraction constant;
    
    public Function(common.Fraction factor,common.Fraction constant,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.factor = factor;
        this.constant = constant;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public common.Fraction getFactor() throws ModelException {
        return this.factor;
    }
    public void setFactor(common.Fraction newValue) throws ModelException {
        this.factor = newValue;
    }
    public common.Fraction getConstant() throws ModelException {
        return this.constant;
    }
    public void setConstant(common.Fraction newValue) throws ModelException {
        this.constant = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFunction(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    public int getFactorIndex() throws ModelException {
        return 0;
    }
    public int getConstantIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "factor";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "constant";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getFactor();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getConstant();
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
            this.setFactor(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setConstant(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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
