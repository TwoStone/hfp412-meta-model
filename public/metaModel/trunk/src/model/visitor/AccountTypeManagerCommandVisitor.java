
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAccountTypeCommand;

public interface AccountTypeManagerCommandVisitor {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    
}
