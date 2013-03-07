
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAccountCommand;

public interface AccountManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
