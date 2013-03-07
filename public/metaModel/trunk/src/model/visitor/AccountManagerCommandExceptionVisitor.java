
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAccountCommand;

public interface AccountManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
