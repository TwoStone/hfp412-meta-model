package view;

import view.objects.*;

import view.visitor.*;

public interface AssociationManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<AssociationView> getAssociations() throws ModelException ;
    public void setAssociations(java.util.Vector<AssociationView> newValue) throws ModelException ;
    public java.util.Vector<HierarchyView> getHierarchies() throws ModelException ;
    public void setHierarchies(java.util.Vector<HierarchyView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

