package view;

import view.visitor.*;

public interface UnitTypeView extends AbsUnitTypeView {
    
    public UnitView getDefaultUnit() throws ModelException ;
    public void setDefaultUnit(UnitView newValue) throws ModelException ;
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException;
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

