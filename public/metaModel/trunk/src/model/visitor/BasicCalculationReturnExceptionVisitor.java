
package model.visitor;
import model.UserException;
public interface BasicCalculationReturnExceptionVisitor<R, E extends UserException> extends UnitImutabCalcReturnExceptionVisitor<R, E> ,UnitMutabCalcReturnExceptionVisitor<R, E> {
    
    
}
