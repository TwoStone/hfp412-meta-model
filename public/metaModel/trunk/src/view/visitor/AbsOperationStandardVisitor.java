
package view.visitor;

import view.*;

public abstract class AbsOperationStandardVisitor implements AbsOperationVisitor {
    
    public void handleOperation(OperationView operation) throws ModelException{
        this.standardHandling(operation);
    }
    public void handleAssociation(AssociationView association) throws ModelException{
        this.standardHandling(association);
    }
    protected abstract void standardHandling(AbsOperationView absOperation) throws ModelException;
}
