
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateQuantityCommand;

public interface QuantityManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    
}
