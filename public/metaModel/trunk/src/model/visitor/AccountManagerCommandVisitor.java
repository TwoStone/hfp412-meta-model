
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAccountCommand;

public interface AccountManagerCommandVisitor {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
