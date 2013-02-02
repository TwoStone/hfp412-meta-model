
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateQuantityCommand;
import persistence.QuantityManagerCommand;

public abstract class QuantityManagerCommandStandardVisitor implements QuantityManagerCommandVisitor {
    
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    protected abstract void standardHandling(QuantityManagerCommand quantityManagerCommand) throws PersistenceException;
}
