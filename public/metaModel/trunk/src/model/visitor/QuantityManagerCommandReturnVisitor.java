
package model.visitor;

import persistence.*;

public interface QuantityManagerCommandReturnVisitor<R> {
    
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public R handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException;
    public R handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException;
    public R handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    
}
