
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends TransactionManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
