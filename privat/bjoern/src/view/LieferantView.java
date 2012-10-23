package view;

public interface LieferantView extends RolleView {
    
    public java.util.Vector<ProduktView> getPortfolio() throws ModelException ;
    public void setPortfolio(java.util.Vector<ProduktView> newValue) throws ModelException ;
    
    public void accept(view.visitor.RolleVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RolleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RolleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
