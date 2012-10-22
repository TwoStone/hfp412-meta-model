package view;

import view.objects.*;

public interface ActorManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<ActorView> getActors() throws ModelException ;
    public void setActors(java.util.Vector<ActorView> newValue) throws ModelException ;
    public long getNextOrderId() throws ModelException ;
    public void setNextOrderId(long newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

