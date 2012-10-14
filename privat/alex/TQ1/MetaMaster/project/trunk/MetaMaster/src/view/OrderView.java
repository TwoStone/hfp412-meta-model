package view;

import view.objects.*;

public interface OrderView extends Anything, AbstractViewProxi {
    
    public PositionView getPosition() throws ModelException ;
    public void setPosition(PositionView newValue) throws ModelException ;
    public CustomerView getCustomer() throws ModelException ;
    public void setCustomer(CustomerView newValue) throws ModelException ;
    public SupplierView getContractor() throws ModelException ;
    public void setContractor(SupplierView newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

