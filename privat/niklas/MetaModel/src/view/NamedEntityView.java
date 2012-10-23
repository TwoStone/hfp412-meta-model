package view;

import view.objects.*;

public interface NamedEntityView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

