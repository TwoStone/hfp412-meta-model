package view;

import view.visitor.*;

public interface CompUnitView extends AbsUnitView {
    
    public java.util.Vector<ReferenceView> getRefs() throws ModelException ;
    public void setRefs(java.util.Vector<ReferenceView> newValue) throws ModelException ;
    
    public void accept(AbsUnitVisitor visitor) throws ModelException;
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

