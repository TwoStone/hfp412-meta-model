package view;

import view.objects.*;

public interface OrderItemView extends Anything, AbstractViewProxi {
    
    public long getQuantity() throws ModelException ;
    public void setQuantity(long newValue) throws ModelException ;
    public ProductView getProduct() throws ModelException ;
    public void setProduct(ProductView newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

