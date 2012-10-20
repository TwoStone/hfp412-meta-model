
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends TypeManagerCommandReturnExceptionVisitor<R, E> ,AspectManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
