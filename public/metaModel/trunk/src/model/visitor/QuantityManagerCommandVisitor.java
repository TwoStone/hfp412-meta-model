
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddCommand;
import persistence.PersistentConvertCommand;
import persistence.PersistentConvertToDefaultCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentDivCommand;
import persistence.PersistentMulCommand;
import persistence.PersistentSubCommand;

public interface QuantityManagerCommandVisitor {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException;
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException;
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    
}
