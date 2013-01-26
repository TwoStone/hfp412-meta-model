package view;

import view.visitor.*;

public interface MAbstractProductTypeView extends MComplexTypeView {
    
    
    public void accept(MAbstractProductTypeVisitor visitor) throws ModelException;
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

