
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends AssociationManagerCommandExceptionVisitor<E>,TypeManagerCommandExceptionVisitor<E>,AspectManagerCommandExceptionVisitor<E>{
    
    
}
