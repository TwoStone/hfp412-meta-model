
package model.visitor;

import persistence.*;

public interface AccountTypeManagerCommandVisitor {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    
}
