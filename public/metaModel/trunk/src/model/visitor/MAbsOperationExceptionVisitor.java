
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbsOperationExceptionVisitor<E extends UserException> {
    
    public void handleMOperation(PersistentMOperation mOperation) throws PersistenceException, E;
    
}
