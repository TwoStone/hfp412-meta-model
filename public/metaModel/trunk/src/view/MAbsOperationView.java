package view;

import view.objects.*;

import view.visitor.*;

public interface MAbsOperationView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    public MType getSource() throws ModelException ;
    public void setSource(MType newValue) throws ModelException ;
    public MType getTarget() throws ModelException ;
    public void setTarget(MType newValue) throws ModelException ;
    public java.util.Vector<MFormalParameterView> getParameters() throws ModelException ;
    public void setParameters(java.util.Vector<MFormalParameterView> newValue) throws ModelException ;
    
    public void accept(MAbsOperationVisitor visitor) throws ModelException;
    public <R> R accept(MAbsOperationReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MAbsOperationExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MAbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

