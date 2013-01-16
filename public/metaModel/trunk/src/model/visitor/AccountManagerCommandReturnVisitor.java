
package model.visitor;

import persistence.*;

public interface AccountManagerCommandReturnVisitor<R> {
    
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
