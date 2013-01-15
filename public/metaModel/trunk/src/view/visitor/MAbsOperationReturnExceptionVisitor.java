
package view.visitor;
import view.UserException;
import view.*;

public interface MAbsOperationReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMOperation(MOperationView mOperation) throws ModelException, E;
    
}
