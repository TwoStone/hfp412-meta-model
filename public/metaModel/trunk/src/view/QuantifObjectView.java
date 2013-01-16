package view;

import view.objects.*;

import view.visitor.*;

public interface QuantifObjectView extends Anything, AbstractViewProxi {
    
    public InstanceObjectView getObject() throws ModelException ;
    public void setObject(InstanceObjectView newValue) throws ModelException ;
    
    public void accept(QuantifObjectVisitor visitor) throws ModelException;
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

