package view;

import view.objects.*;

import view.visitor.*;

public interface AspectManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<MAspectView> getAspects() throws ModelException ;
    public void setAspects(java.util.Vector<MAspectView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

