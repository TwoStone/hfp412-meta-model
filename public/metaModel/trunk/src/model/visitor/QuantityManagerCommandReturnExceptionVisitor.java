
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantityManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    
}
