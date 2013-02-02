
package model.visitor;

import persistence.AccountTypeManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentCreateAccountTypeCommand;

public abstract class AccountTypeManagerCommandStandardVisitor implements AccountTypeManagerCommandVisitor {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException{
        this.standardHandling(createAccountTypeCommand);
    }
    protected abstract void standardHandling(AccountTypeManagerCommand accountTypeManagerCommand) throws PersistenceException;
}
