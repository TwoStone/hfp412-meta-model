package view;

import view.objects.*;

import view.visitor.*;

public interface MBooleanView extends Anything, AbstractViewProxi {
    
    
    public void accept(MBooleanVisitor visitor) throws ModelException;
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

