package view;

import view.objects.*;

public interface OrderView extends Anything, AbstractViewProxi {
    
    public CustomerView getCustomer() throws ModelException ;
    public void setCustomer(CustomerView newValue) throws ModelException ;
    public SupplierView getSupplier() throws ModelException ;
    public void setSupplier(SupplierView newValue) throws ModelException ;
    public java.util.Vector<PositionView> getPositions() throws ModelException ;
    public void setPositions(java.util.Vector<PositionView> newValue) throws ModelException ;
    public long getOrderId() throws ModelException ;
    public void setOrderId(long newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

