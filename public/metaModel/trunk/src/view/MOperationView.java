package view;

import view.visitor.*;

public interface MOperationView extends MAbsOperationView {
    
    
    public void accept(MAbsOperationVisitor visitor) throws ModelException;
    public <R> R accept(MAbsOperationReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MAbsOperationExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MAbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

