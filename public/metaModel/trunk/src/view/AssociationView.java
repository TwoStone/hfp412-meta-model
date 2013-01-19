package view;

import view.objects.*;

import view.visitor.*;

public interface AssociationView extends Anything, AbstractViewProxi {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    public MTypeView getSource() throws ModelException ;
    public void setSource(MTypeView newValue) throws ModelException ;
    public MTypeView getTarget() throws ModelException ;
    public void setTarget(MTypeView newValue) throws ModelException ;
    public java.util.Vector<HierarchyView> getHierarchies() throws ModelException ;
    public void setHierarchies(java.util.Vector<HierarchyView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

