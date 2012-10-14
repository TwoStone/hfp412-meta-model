package view;

import view.objects.*;

public interface RoleView extends Anything, AbstractViewProxi {
    
    public ActorView getRoleOwner() throws ModelException ;
    public void setRoleOwner(ActorView newValue) throws ModelException ;
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

