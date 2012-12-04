
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends AssociationManagerCommandReturnExceptionVisitor<R, E> ,TypeManagerCommandReturnExceptionVisitor<R, E> ,AspectManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
