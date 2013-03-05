
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentOperation;

public interface AbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException, E;
    public void handleAssociation(PersistentAssociation association) throws PersistenceException, E;
    
}
