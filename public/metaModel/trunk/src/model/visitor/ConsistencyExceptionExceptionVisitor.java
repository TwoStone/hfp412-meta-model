
package model.visitor;
import model.UserException;
import persistence.PersistenceException;

public interface ConsistencyExceptionExceptionVisitor<E extends UserException> {
    
    public void handleDeletedException(model.DeletedException deletedException) throws PersistenceException, E;
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException, E;
    
}
