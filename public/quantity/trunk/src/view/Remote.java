package view;

import view.objects.*;

public interface Remote extends AbstractViewProxi {
    
    public void accept(view.visitor.RemoteVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
}

