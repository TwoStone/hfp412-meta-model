
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends TypeManagerCommandReturnExceptionVisitor<R, E> ,ConversionManagerCommandReturnExceptionVisitor<R, E> ,QuantityManagerCommandReturnExceptionVisitor<R, E> ,UnitManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
