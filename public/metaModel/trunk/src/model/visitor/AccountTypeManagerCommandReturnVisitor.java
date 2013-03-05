
package model.visitor;

import persistence.*;

public interface AccountTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    
}
