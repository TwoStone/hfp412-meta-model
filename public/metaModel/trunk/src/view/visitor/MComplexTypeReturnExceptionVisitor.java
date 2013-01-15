
package view.visitor;
import view.UserException;
import view.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MAbstractSumTypeReturnExceptionVisitor<R, E> ,MAbstractProductTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException, E;
    
}
