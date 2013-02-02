
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateQuantityCommand;

public interface QuantityManagerCommandVisitor {
    
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    
}
