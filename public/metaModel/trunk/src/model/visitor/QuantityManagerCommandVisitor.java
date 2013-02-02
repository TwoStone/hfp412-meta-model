
package model.visitor;

import persistence.*;

public interface QuantityManagerCommandVisitor {
    
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    
}
