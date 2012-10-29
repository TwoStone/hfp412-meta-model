package view;

import view.objects.*;

import view.visitor.*;

public interface AbsQuantityView extends Anything, AbstractViewProxi {
    
    
    public void accept(AbsQuantityVisitor visitor) throws ModelException;
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

