
package model.visitor;

import persistence.*;

public abstract class AccountTypeManagerCommandStandardVisitor implements AccountTypeManagerCommandVisitor {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException{
        this.standardHandling(createAccountTypeCommand);
    }
    protected abstract void standardHandling(AccountTypeManagerCommand accountTypeManagerCommand) throws PersistenceException;
}
