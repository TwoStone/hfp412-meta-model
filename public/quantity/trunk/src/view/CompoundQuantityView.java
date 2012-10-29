package view;

import view.visitor.*;

public interface CompoundQuantityView extends AbsQuantityView {
    
    public java.util.Vector<QuantityView> getParts() throws ModelException ;
    public void setParts(java.util.Vector<QuantityView> newValue) throws ModelException ;
    
    public void accept(AbsQuantityVisitor visitor) throws ModelException;
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

