package view;

import view.objects.*;

import view.visitor.*;

public interface LinkManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<LinkView> getLinks() throws ModelException ;
    public void setLinks(java.util.Vector<LinkView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

