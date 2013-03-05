
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAspectCommand;

public interface AspectManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    
}
