
package model.visitor;

import persistence.*;

public abstract class QuantityManagerCommandStandardVisitor implements QuantityManagerCommandVisitor {
    
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException{
        this.standardHandling(convertCommand);
    }
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException{
        this.standardHandling(convertToDefaultCommand);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    protected abstract void standardHandling(QuantityManagerCommand quantityManagerCommand) throws PersistenceException;
}
