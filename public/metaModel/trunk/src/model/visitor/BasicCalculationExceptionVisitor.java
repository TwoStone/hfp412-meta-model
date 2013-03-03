
package model.visitor;
import model.UserException;
public interface BasicCalculationExceptionVisitor<E extends UserException> extends UnitImutabCalcExceptionVisitor<E>,UnitMutabCalcExceptionVisitor<E>{
    
    
}
