
package model.visitor;
import model.UserException;
public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MAbstractTypeDisjunctionReturnExceptionVisitor<R, E> ,MAbstractTypeConjunctionReturnExceptionVisitor<R, E> {
    
    
}
