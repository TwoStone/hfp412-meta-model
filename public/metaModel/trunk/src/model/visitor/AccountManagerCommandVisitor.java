
package model.visitor;

import persistence.*;

public interface AccountManagerCommandVisitor {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
