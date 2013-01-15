package view;

import view.objects.*;

import view.visitor.*;

public interface ActualParameterView extends Anything, AbstractViewProxi {
    
    public MFormalParameterView getType() throws ModelException ;
    public void setType(MFormalParameterView newValue) throws ModelException ;
    public InstanceObjectView getValue() throws ModelException ;
    public void setValue(InstanceObjectView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

