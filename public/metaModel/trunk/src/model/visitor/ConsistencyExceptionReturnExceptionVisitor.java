
package model.visitor;
import model.UserException;
import persistence.*;

public interface ConsistencyExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDeletedException(model.DeletedException deletedException) throws PersistenceException, E;
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException, E;
    
}
