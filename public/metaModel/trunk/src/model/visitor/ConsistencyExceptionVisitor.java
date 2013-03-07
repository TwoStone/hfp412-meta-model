
package model.visitor;

import persistence.PersistenceException;

public interface ConsistencyExceptionVisitor {
    
    public void handleDeletedException(model.DeletedException deletedException) throws PersistenceException;
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    
}
