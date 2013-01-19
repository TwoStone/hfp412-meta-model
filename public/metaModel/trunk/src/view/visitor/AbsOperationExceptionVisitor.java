
package view.visitor;
import view.UserException;
import view.*;

public interface AbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleOperation(OperationView operation) throws ModelException, E;
    
}
