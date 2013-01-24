
package view.visitor;
import view.UserException;
import view.*;

public interface AbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleOperation(OperationView operation) throws ModelException, E;
    public void handleAssociation(AssociationView association) throws ModelException, E;
    
}
