package view;

import view.objects.*;

public interface ActorView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    public java.util.Vector<RoleView> getMyRoles() throws ModelException ;
    
    public void accept(view.visitor.ActorVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.ActorReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.ActorExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

