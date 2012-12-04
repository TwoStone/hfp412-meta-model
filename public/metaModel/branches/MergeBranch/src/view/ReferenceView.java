package view;

import view.objects.*;

import view.visitor.*;

public interface ReferenceView extends Anything, AbstractViewProxi {
    
    public ReferenceTypeView getType() throws ModelException ;
    public void setType(ReferenceTypeView newValue) throws ModelException ;
    public long getExponent() throws ModelException ;
    public void setExponent(long newValue) throws ModelException ;
    public UnitView getRef() throws ModelException ;
    public void setRef(UnitView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

