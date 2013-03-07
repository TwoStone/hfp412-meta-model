
package model.visitor;

import persistence.*;

public abstract class QuantityManagerCommandStandardVisitor implements QuantityManagerCommandVisitor {
    
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException{
        this.standardHandling(convertCommand);
    }
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException{
        this.standardHandling(addCommand);
    }
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException{
        this.standardHandling(subCommand);
    }
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException{
        this.standardHandling(divCommand);
    }
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException{
        this.standardHandling(convertToDefaultCommand);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException{
        this.standardHandling(mulCommand);
    }
    protected abstract void standardHandling(QuantityManagerCommand quantityManagerCommand) throws PersistenceException;
}
