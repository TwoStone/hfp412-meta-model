package view;

public interface QuantityView extends AbsQuantityView {
    
    public FractionView getAmount() throws ModelException ;
    public void setAmount(FractionView newValue) throws ModelException ;
    public UnitView getUnit() throws ModelException ;
    public void setUnit(UnitView newValue) throws ModelException ;
    
    public void accept(view.visitor.AbsQuantityVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsQuantityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

