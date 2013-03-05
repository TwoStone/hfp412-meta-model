
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddCommand;
import persistence.PersistentConvertCommand;
import persistence.PersistentConvertToDefaultCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentDivCommand;
import persistence.PersistentMulCommand;
import persistence.PersistentSubCommand;

public interface QuantityManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public R handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException, E;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public R handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException, E;
    public R handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException, E;
    public R handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException, E;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    
}
