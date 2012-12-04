package view;

import view.objects.*;

import view.visitor.*;

public interface FunctionView extends Anything, AbstractViewProxi {
    
    public common.Fraction getFactor() throws ModelException ;
    public void setFactor(common.Fraction newValue) throws ModelException ;
    public common.Fraction getConstant() throws ModelException ;
    public void setConstant(common.Fraction newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

