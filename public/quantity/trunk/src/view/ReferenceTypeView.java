package view;

import view.objects.*;

import view.visitor.*;

public interface ReferenceTypeView extends Anything, AbstractViewProxi {
    
    public long getExponent() throws ModelException ;
    public void setExponent(long newValue) throws ModelException ;
    public UnitTypeView getRef() throws ModelException ;
    public void setRef(UnitTypeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

