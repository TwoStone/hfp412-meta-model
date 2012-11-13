
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends UnitTypeManagerCommandExceptionVisitor<E>,ConversionManagerCommandExceptionVisitor<E>,QuantityManagerCommandExceptionVisitor<E>{
    
    
}
