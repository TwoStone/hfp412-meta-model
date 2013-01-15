package view;

import view.visitor.*;

public interface MAbstractSumTypeView extends MComplexTypeView {
    
    
    public void accept(MAbstractSumTypeVisitor visitor) throws ModelException;
    public <R> R accept(MAbstractSumTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MAbstractSumTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

