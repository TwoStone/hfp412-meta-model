package view;

import view.objects.*;

import view.visitor.*;

public interface BooleanValueView extends Anything, AbstractViewProxi {
    
    
    public void accept(BooleanValueVisitor visitor) throws ModelException;
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

