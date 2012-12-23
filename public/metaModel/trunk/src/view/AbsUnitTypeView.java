package view;

import view.objects.*;

import view.visitor.*;

public interface AbsUnitTypeView extends Anything, AbstractViewProxi {
    
    public AbsUnitView getDefaultUnit() throws ModelException ;
    public void setDefaultUnit(AbsUnitView newValue) throws ModelException ;
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException;
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

