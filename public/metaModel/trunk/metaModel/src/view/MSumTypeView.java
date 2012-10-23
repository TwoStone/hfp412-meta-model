package view;

public interface MSumTypeView extends MComplexTypeView {
    
    
    public void accept(view.visitor.MComplexTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.MComplexTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.MTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.MTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.MTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

