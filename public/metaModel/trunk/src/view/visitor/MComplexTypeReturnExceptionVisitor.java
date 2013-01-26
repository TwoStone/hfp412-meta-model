
package view.visitor;
import view.UserException;
public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MAbstractSumTypeReturnExceptionVisitor<R, E> ,MAbstractProductTypeReturnExceptionVisitor<R, E> {
    
    
}
