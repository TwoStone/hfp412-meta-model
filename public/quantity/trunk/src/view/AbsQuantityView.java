package view;

import view.objects.*;

public interface AbsQuantityView extends Anything, AbstractViewProxi {
    
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

