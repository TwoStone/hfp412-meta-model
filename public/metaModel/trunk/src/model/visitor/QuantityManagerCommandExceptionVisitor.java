
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantityManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    
}
