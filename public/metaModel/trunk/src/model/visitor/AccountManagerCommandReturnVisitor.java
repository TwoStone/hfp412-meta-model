
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAccountCommand;

public interface AccountManagerCommandReturnVisitor<R> {
    
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
