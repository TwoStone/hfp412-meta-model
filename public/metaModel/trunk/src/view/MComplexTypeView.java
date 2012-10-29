package view;

import view.objects.*;

import view.visitor.*;

public interface MComplexTypeView extends MType, Anything, AbstractViewProxi {
    
    public java.util.Vector<MType> getContainedTypes() throws ModelException ;
    public void setContainedTypes(java.util.Vector<MType> newValue) throws ModelException ;
    public String getTypeLinkOperator() throws ModelException ;
    
    public void accept(MComplexTypeVisitor visitor) throws ModelException;
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

