
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends UnitTypeManagerCommandReturnExceptionVisitor<R, E> ,ConversionManagerCommandReturnExceptionVisitor<R, E> ,QuantityManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
