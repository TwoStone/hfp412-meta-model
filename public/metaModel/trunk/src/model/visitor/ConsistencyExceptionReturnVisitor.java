
package model.visitor;

import persistence.*;

public interface ConsistencyExceptionReturnVisitor<R> {
    
    public R handleDeletedException(model.DeletedException deletedException) throws PersistenceException;
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    
}
