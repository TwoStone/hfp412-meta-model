
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAspectCommand;

public interface AspectManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    
}
