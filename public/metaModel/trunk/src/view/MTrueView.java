package view;

import view.visitor.*;

public interface MTrueView extends MBooleanView {
    
    
    public void accept(MBooleanVisitor visitor) throws ModelException;
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

