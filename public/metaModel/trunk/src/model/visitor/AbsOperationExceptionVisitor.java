
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException, E;
    
}
