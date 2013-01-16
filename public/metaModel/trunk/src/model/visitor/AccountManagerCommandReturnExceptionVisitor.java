
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
