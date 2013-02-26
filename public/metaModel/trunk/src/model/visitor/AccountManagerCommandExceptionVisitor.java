
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
