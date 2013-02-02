
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentOperation;

public interface AbsOperationReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleOperation(PersistentOperation operation) throws PersistenceException, E;
    public R handleAssociation(PersistentAssociation association) throws PersistenceException, E;
    
}
