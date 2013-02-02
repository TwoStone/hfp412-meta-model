
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateQuantityCommand;

public interface QuantityManagerCommandReturnVisitor<R> {
    
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    
}
