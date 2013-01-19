package view;

import view.objects.*;

import view.visitor.*;

public interface OperationManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<OperationView> getOperations() throws ModelException ;
    public void setOperations(java.util.Vector<OperationView> newValue) throws ModelException ;
    public java.util.Vector<OperationView> getStaticOperations() throws ModelException ;
    public java.util.Vector<OperationView> getConstants() throws ModelException ;
    public java.util.Vector<FormalParameterView> getFormalParameters() throws ModelException ;
    public void setFormalParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

