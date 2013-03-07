
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddCommand;
import persistence.PersistentConvertCommand;
import persistence.PersistentConvertToDefaultCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentDivCommand;
import persistence.PersistentMulCommand;
import persistence.PersistentSubCommand;
import persistence.QuantityManagerCommand;

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
