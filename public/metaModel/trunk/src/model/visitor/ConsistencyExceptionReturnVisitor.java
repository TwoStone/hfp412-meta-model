
package model.visitor;

import persistence.PersistenceException;

public interface ConsistencyExceptionReturnVisitor<R> {
    
    public R handleDeletedException(model.DeletedException deletedException) throws PersistenceException;
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    
}
