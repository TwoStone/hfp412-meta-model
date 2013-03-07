
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAccountTypeCommand;

public interface AccountTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    
}
