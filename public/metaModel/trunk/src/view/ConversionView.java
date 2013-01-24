package view;

import view.objects.*;

import view.visitor.*;

public interface ConversionView extends Anything, AbstractViewProxi {
    
    public UnitView getSource() throws ModelException ;
    public void setSource(UnitView newValue) throws ModelException ;
    public FunctionView getMyFunction() throws ModelException ;
    public void setMyFunction(FunctionView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
