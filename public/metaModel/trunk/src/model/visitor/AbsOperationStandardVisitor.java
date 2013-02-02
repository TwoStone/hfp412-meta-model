
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAssociation;
import persistence.PersistentOperation;

public abstract class AbsOperationStandardVisitor implements AbsOperationVisitor {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException{
        this.standardHandling(operation);
    }
    public void handleAssociation(PersistentAssociation association) throws PersistenceException{
        this.standardHandling(association);
    }
    protected abstract void standardHandling(PersistentAbsOperation absOperation) throws PersistenceException;
}
