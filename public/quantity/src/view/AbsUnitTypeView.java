package view;

import view.objects.*;

public interface AbsUnitTypeView extends Anything, AbstractViewProxi {
    
    
    public void accept(view.visitor.AbsUnitTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

