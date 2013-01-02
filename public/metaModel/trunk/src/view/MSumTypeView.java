package view;

import view.visitor.*;

public interface MSumTypeView extends MComplexTypeView {
    
    
    public void accept(MSumTypeVisitor visitor) throws ModelException;
    public <R> R accept(MSumTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MSumTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MSumTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(MComplexTypeVisitor visitor) throws ModelException;
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(MTypeVisitor visitor) throws ModelException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

