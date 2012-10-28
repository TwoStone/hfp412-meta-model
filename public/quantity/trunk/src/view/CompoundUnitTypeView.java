package view;

public interface CompoundUnitTypeView extends AbsUnitTypeView {
    
    
    public void accept(view.visitor.AbsUnitTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

