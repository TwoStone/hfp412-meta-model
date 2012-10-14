package view;

public interface SupplierView extends RoleView {
    
    public java.util.Vector<ProductView> getPortfolio() throws ModelException ;
    public void setPortfolio(java.util.Vector<ProductView> newValue) throws ModelException ;
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

