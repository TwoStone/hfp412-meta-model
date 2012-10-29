package view;

import view.visitor.*;

public interface QuantityView extends AbsQuantityView {
    
    public common.Fraction getAmount() throws ModelException ;
    public void setAmount(common.Fraction newValue) throws ModelException ;
    public UnitView getUnit() throws ModelException ;
    public void setUnit(UnitView newValue) throws ModelException ;
    
    public void accept(AbsQuantityVisitor visitor) throws ModelException;
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

