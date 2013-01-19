
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Conversion extends ViewObject implements ConversionView{
    
    protected UnitView source;
    protected UnitTypeView type;
    protected FunctionView myFunction;
    
    public Conversion(UnitView source,UnitTypeView type,FunctionView myFunction,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.source = source;
        this.type = type;
        this.myFunction = myFunction;        
    }
    
    static public long getTypeId() {
        return 177;
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
    public UnitTypeView getType() throws ModelException {
        return this.type;
    }
    public void setType(UnitTypeView newValue) throws ModelException {
        this.type = newValue;
    }
    public FunctionView getMyFunction() throws ModelException {
        return this.myFunction;
    }
    public void setMyFunction(FunctionView newValue) throws ModelException {
        this.myFunction = newValue;
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
        UnitTypeView type = this.getType();
        if (type != null) {
            ((ViewProxi)type).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(type.getClassId(), type.getId())));
        }
        FunctionView myFunction = this.getMyFunction();
        if (myFunction != null) {
            ((ViewProxi)myFunction).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(myFunction.getClassId(), myFunction.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceConversionWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getType() != null) return new TypeConversionWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getMyFunction() != null) return new MyFunctionConversionWrapper(this, originalIndex, (ViewRoot)this.getMyFunction());
        if(this.getMyFunction() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + (this.getMyFunction() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getType() == null ? true : false)
            && (this.getMyFunction() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getMyFunction() != null && this.getMyFunction().equals(child)) return result;
        if(this.getMyFunction() != null) result = result + 1;
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
