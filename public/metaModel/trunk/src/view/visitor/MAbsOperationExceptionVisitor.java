
package view.visitor;
import view.UserException;
import view.*;

public interface MAbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleMOperation(MOperationView mOperation) throws ModelException, E;
    
}
