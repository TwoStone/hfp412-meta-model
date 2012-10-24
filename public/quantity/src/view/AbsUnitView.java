package view;

import view.objects.*;

public interface AbsUnitView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(view.visitor.AbsUnitVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsUnitReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

