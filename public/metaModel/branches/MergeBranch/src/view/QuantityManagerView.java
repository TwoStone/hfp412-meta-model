package view;

import view.objects.*;

import view.visitor.*;

public interface QuantityManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<AbsQuantityView> getQuantities() throws ModelException ;
    public void setQuantities(java.util.Vector<AbsQuantityView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

