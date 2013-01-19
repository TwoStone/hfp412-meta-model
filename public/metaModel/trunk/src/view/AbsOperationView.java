package view;

import view.objects.*;

import view.visitor.*;

public interface AbsOperationView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    public MTypeView getSource() throws ModelException ;
    public void setSource(MTypeView newValue) throws ModelException ;
    public MTypeView getTarget() throws ModelException ;
    public void setTarget(MTypeView newValue) throws ModelException ;
    public java.util.Vector<FormalParameterView> getParameters() throws ModelException ;
    public void setParameters(java.util.Vector<FormalParameterView> newValue) throws ModelException ;
    
    public void accept(AbsOperationVisitor visitor) throws ModelException;
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

