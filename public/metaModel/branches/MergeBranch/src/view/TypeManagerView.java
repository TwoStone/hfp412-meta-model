package view;

import view.objects.*;

import view.visitor.*;

public interface TypeManagerView extends Anything, AbstractViewProxi {
    
    public java.util.Vector<MAtomicTypeView> getAtomicTypes() throws ModelException ;
    public void setAtomicTypes(java.util.Vector<MAtomicTypeView> newValue) throws ModelException ;
    public java.util.Vector<MProductTypeView> getProductTypes() throws ModelException ;
    public void setProductTypes(java.util.Vector<MProductTypeView> newValue) throws ModelException ;
    public java.util.Vector<MSumTypeView> getSumTypes() throws ModelException ;
    public void setSumTypes(java.util.Vector<MSumTypeView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

