
package model.visitor;

import persistence.PersistenceException;

public abstract class ConsistencyExceptionStandardVisitor implements ConsistencyExceptionVisitor {
    
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException{
        this.standardHandling(consistencyException);
    }
    public void handleDeletedException(model.DeletedException deletedException) throws PersistenceException{
        this.standardHandling(deletedException);
    }
    protected abstract void standardHandling(model.ConsistencyException consistencyException) throws PersistenceException;
}
