package view;

import view.objects.*;

public interface MComplexTypeView extends MType, Anything, AbstractViewProxi {
    
    public java.util.Vector<MType> getContainedTypes() throws ModelException ;
    public void setContainedTypes(java.util.Vector<MType> newValue) throws ModelException ;
    public String getTypeLinkOperator() throws ModelException ;
    
    public void accept(view.visitor.MComplexTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.MComplexTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

