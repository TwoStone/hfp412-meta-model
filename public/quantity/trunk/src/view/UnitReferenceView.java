package view;

public interface UnitReferenceView extends AbsUnitView {
    
    
    public void accept(view.visitor.AbsUnitVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsUnitReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

