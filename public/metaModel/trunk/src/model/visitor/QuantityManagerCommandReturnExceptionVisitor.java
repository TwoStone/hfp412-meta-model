
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantityManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    
}
