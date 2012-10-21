package view;

import view.objects.*;

public interface TransactionManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<AkteurView> getAkteure() throws ModelException ;
    public void setAkteure(java.util.Vector<AkteurView> newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

