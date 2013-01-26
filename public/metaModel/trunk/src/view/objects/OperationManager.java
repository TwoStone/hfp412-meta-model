
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class OperationManager extends ViewObject implements OperationManagerView{
    
    protected java.util.Vector<OperationView> operations;
    protected java.util.Vector<OperationView> staticOperations;
    protected java.util.Vector<OperationView> constants;
    protected java.util.Vector<FormalParameterView> formalParameters;
    
    public OperationManager(java.util.Vector<OperationView> operations,java.util.Vector<OperationView> staticOperations,java.util.Vector<OperationView> constants,java.util.Vector<FormalParameterView> formalParameters,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.operations = operations;
        this.staticOperations = staticOperations;
        this.constants = constants;
        this.formalParameters = formalParameters;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<OperationView> getOperations() throws ModelException {
        return this.operations;
    }
    public void setOperations(java.util.Vector<OperationView> newValue) throws ModelException {
        this.operations = newValue;
    }
    public java.util.Vector<OperationView> getStaticOperations() throws ModelException {
        return this.staticOperations;
    }
    public java.util.Vector<OperationView> getConstants() throws ModelException {
        return this.constants;
    }
    public java.util.Vector<FormalParameterView> getFormalParameters() throws ModelException {
        return this.formalParameters;
    }
    public void setFormalParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException {
        this.formalParameters = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleOperationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleOperationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleOperationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleOperationManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> operations = this.getOperations();
        if (operations != null) {
            ViewObject.resolveVectorProxies(operations, resultTable);
        }
        java.util.Vector<?> staticOperations = this.getStaticOperations();
        if (staticOperations != null) {
            ViewObject.resolveVectorProxies(staticOperations, resultTable);
        }
        java.util.Vector<?> constants = this.getConstants();
        if (constants != null) {
            ViewObject.resolveVectorProxies(constants, resultTable);
        }
        java.util.Vector<?> formalParameters = this.getFormalParameters();
        if (formalParameters != null) {
            ViewObject.resolveVectorProxies(formalParameters, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getOperations().size()) return new OperationsOperationManagerWrapper(this, originalIndex, (ViewRoot)this.getOperations().get(index));
        index = index - this.getOperations().size();
        if(index < this.getStaticOperations().size()) return new StaticOperationsOperationManagerWrapper(this, originalIndex, (ViewRoot)this.getStaticOperations().get(index));
        index = index - this.getStaticOperations().size();
        if(index < this.getConstants().size()) return new ConstantsOperationManagerWrapper(this, originalIndex, (ViewRoot)this.getConstants().get(index));
        index = index - this.getConstants().size();
        if(index < this.getFormalParameters().size()) return new FormalParametersOperationManagerWrapper(this, originalIndex, (ViewRoot)this.getFormalParameters().get(index));
        index = index - this.getFormalParameters().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOperations().size())
            + (this.getStaticOperations().size())
            + (this.getConstants().size())
            + (this.getFormalParameters().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getOperations().size() == 0)
            && (this.getStaticOperations().size() == 0)
            && (this.getConstants().size() == 0)
            && (this.getFormalParameters().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getOperationsIterator = this.getOperations().iterator();
        while(getOperationsIterator.hasNext()){
            if(getOperationsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getStaticOperationsIterator = this.getStaticOperations().iterator();
        while(getStaticOperationsIterator.hasNext()){
            if(getStaticOperationsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getConstantsIterator = this.getConstants().iterator();
        while(getConstantsIterator.hasNext()){
            if(getConstantsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getFormalParametersIterator = this.getFormalParameters().iterator();
        while(getFormalParametersIterator.hasNext()){
            if(getFormalParametersIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
