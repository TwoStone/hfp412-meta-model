
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantityManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException, E;
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException, E;
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException, E;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    
}
