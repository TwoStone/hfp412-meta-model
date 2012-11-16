package view;

import view.visitor.*;

public interface BooleanTrueView extends BooleanValueView {
    
    
    public void accept(BooleanValueVisitor visitor) throws ModelException;
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

