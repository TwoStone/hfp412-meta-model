package view;

import view.objects.*;

public interface MType extends AbstractViewProxi {
    
    public void accept(view.visitor.MTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.MTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.MTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
}

