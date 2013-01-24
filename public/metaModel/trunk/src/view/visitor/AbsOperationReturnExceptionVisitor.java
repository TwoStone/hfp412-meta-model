
package view.visitor;
import view.UserException;
import view.*;

public interface AbsOperationReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleOperation(OperationView operation) throws ModelException, E;
    public R handleAssociation(AssociationView association) throws ModelException, E;
    
}
