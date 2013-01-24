package view;

import view.visitor.*;

public interface AssociationView extends AbsOperationView {
    
    public java.util.Vector<HierarchyView> getHierarchies() throws ModelException ;
    public void setHierarchies(java.util.Vector<HierarchyView> newValue) throws ModelException ;
    
    public void accept(AbsOperationVisitor visitor) throws ModelException;
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

