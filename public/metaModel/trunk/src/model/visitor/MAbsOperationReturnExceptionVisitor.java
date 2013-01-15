
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbsOperationReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMOperation(PersistentMOperation mOperation) throws PersistenceException, E;
    
}
