
package view.visitor;

import view.*;

public abstract class AbsOperationStandardVisitor implements AbsOperationVisitor {
    
    public void handleOperation(OperationView operation) throws ModelException{
        this.standardHandling(operation);
    }
    protected abstract void standardHandling(AbsOperationView absOperation) throws ModelException;
}
