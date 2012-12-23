package view;

import view.objects.*;

import view.visitor.*;

public interface AbsUnitView extends Anything, AbstractViewProxi {
    
    public AbsUnitTypeView getType() throws ModelException ;
    public void setType(AbsUnitTypeView newValue) throws ModelException ;
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(AbsUnitVisitor visitor) throws ModelException;
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

