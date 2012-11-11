
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends TypeManagerCommandExceptionVisitor<E>,ConversionManagerCommandExceptionVisitor<E>,QuantityManagerCommandExceptionVisitor<E>,UnitManagerCommandExceptionVisitor<E>{
    
    
}
