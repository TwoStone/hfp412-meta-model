
package model.visitor;
import model.UserException;
public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MAbstractSumTypeReturnExceptionVisitor<R, E> ,MAbstractProductTypeReturnExceptionVisitor<R, E> {
    
    
}
