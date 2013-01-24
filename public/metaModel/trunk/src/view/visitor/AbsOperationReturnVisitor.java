
package view.visitor;

import view.*;

public interface AbsOperationReturnVisitor<R> {
    
    public R handleOperation(OperationView operation) throws ModelException;
    public R handleAssociation(AssociationView association) throws ModelException;
    
}
