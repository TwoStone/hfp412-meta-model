
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Conversion extends ViewObject implements ConversionView{
    
    protected UnitView source;
    protected UnitView target;
    protected common.Fraction factor;
    protected common.Fraction constant;
    protected FunctionView f;
    
    public Conversion(UnitView source,UnitView target,common.Fraction factor,common.Fraction constant,FunctionView f,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.source = source;
        this.target = target;
        this.factor = factor;
        this.constant = constant;
        this.f = f;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public UnitView getSource() throws ModelException {
        return this.source;
    }
    public void setSource(UnitView newValue) throws ModelException {
        this.source = newValue;
    }
    public UnitView getTarget() throws ModelException {
        return this.target;
    }
    public void setTarget(UnitView newValue) throws ModelException {
        this.target = newValue;
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
    public FunctionView getF() throws ModelException {
        return this.f;
    }
    public void setF(FunctionView newValue) throws ModelException {
        this.f = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleConversion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleConversion(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        UnitView source = this.getSource();
        if (source != null) {
            ((ViewProxi)source).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(source.getClassId(), source.getId())));
        }
        UnitView target = this.getTarget();
        if (target != null) {
            ((ViewProxi)target).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(target.getClassId(), target.getId())));
        }
        FunctionView f = this.getF();
        if (f != null) {
            ((ViewProxi)f).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(f.getClassId(), f.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceConversionWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getTarget() != null) return new TargetConversionWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index == 0 && this.getF() != null) return new FConversionWrapper(this, originalIndex, (ViewRoot)this.getF());
        if(this.getF() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getF() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getF() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        if(this.getF() != null && this.getF().equals(child)) return result;
        if(this.getF() != null) result = result + 1;
        return -1;
    }
    public int getFactorIndex() throws ModelException {
        return 0 + (this.getSource() == null ? 0 : 1) + (this.getTarget() == null ? 0 : 1);
    }
    public int getConstantIndex() throws ModelException {
        return 0 + (this.getSource() == null ? 0 : 1) + (this.getTarget() == null ? 0 : 1) + 1;
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Conversion
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
