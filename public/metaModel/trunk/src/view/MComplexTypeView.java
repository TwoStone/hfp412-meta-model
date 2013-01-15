package view;

import view.visitor.*;

public interface MComplexTypeView extends MTypeView {
    
    public java.util.Vector<MTypeView> getContainedTypes() throws ModelException ;
    public void setContainedTypes(java.util.Vector<MTypeView> newValue) throws ModelException ;
    
    public void accept(MComplexTypeVisitor visitor) throws ModelException;
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

