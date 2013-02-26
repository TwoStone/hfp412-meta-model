
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantityManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    
}
