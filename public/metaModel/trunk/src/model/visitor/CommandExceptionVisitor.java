
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends TypeManagerCommandExceptionVisitor<E>,AspectManagerCommandExceptionVisitor<E>{
    
    
}
