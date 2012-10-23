
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends TypeManagerCommandExceptionVisitor<E>,AspectManagerCommandExceptionVisitor<E>{
    
    
}
