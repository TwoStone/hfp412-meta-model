
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Conversion extends ViewObject implements ConversionView{
    
    protected UnitView source;
    protected UnitView target;
    protected FunctionView convFunction;
    
    public Conversion(UnitView source,UnitView target,FunctionView convFunction,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.source = source;
        this.target = target;
        this.convFunction = convFunction;        
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
    public FunctionView getConvFunction() throws ModelException {
        return this.convFunction;
    }
    public void setConvFunction(FunctionView newValue) throws ModelException {
        this.convFunction = newValue;
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
        FunctionView convFunction = this.getConvFunction();
        if (convFunction != null) {
            ((ViewProxi)convFunction).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(convFunction.getClassId(), convFunction.getId())));
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
        if(index == 0 && this.getConvFunction() != null) return new ConvFunctionConversionWrapper(this, originalIndex, (ViewRoot)this.getConvFunction());
        if(this.getConvFunction() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getConvFunction() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getConvFunction() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        if(this.getConvFunction() != null && this.getConvFunction().equals(child)) return result;
        if(this.getConvFunction() != null) result = result + 1;
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
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
