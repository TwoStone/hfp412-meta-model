package view;

import view.objects.*;

public interface AspectManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<MetaAspectView> getAspects() throws ModelException ;
    public void setAspects(java.util.Vector<MetaAspectView> newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

