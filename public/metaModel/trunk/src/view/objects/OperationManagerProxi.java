package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class OperationManagerProxi extends ViewProxi implements OperationManagerView{
    
    public OperationManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public OperationManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> operations_string = (java.util.Vector<String>)resultTable.get("operations");
        java.util.Vector<OperationView> operations = ViewProxi.getProxiVector(operations_string, connectionKey);
        java.util.Vector<String> staticOperations_string = (java.util.Vector<String>)resultTable.get("staticOperations");
        java.util.Vector<OperationView> staticOperations = ViewProxi.getProxiVector(staticOperations_string, connectionKey);
        java.util.Vector<String> constants_string = (java.util.Vector<String>)resultTable.get("constants");
        java.util.Vector<OperationView> constants = ViewProxi.getProxiVector(constants_string, connectionKey);
        java.util.Vector<String> formalParameters_string = (java.util.Vector<String>)resultTable.get("formalParameters");
        java.util.Vector<FormalParameterView> formalParameters = ViewProxi.getProxiVector(formalParameters_string, connectionKey);
        OperationManagerView result$$ = new OperationManager(operations,staticOperations,constants,formalParameters, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<OperationView> getOperations() throws ModelException {
        return ((OperationManager)this.getTheObject()).getOperations();
    }
    public void setOperations(java.util.Vector<OperationView> newValue) throws ModelException {
        ((OperationManager)this.getTheObject()).setOperations(newValue);
    }
    public java.util.Vector<OperationView> getStaticOperations() throws ModelException {
        return ((OperationManager)this.getTheObject()).getStaticOperations();
    }
    public java.util.Vector<OperationView> getConstants() throws ModelException {
        return ((OperationManager)this.getTheObject()).getConstants();
    }
    public java.util.Vector<FormalParameterView> getFormalParameters() throws ModelException {
        return ((OperationManager)this.getTheObject()).getFormalParameters();
    }
    public void setFormalParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException {
        ((OperationManager)this.getTheObject()).setFormalParameters(newValue);
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
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
