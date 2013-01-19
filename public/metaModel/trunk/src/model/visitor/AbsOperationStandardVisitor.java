
package model.visitor;

import persistence.*;

public abstract class AbsOperationStandardVisitor implements AbsOperationVisitor {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException{
        this.standardHandling(operation);
    }
    protected abstract void standardHandling(PersistentAbsOperation absOperation) throws PersistenceException;
}
