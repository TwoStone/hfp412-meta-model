
package model.visitor;

import persistence.AccountCommand;
import persistence.PersistenceException;
import persistence.PersistentAddEntryCommand;
import persistence.PersistentAddSubAccountCommand;

public abstract class AccountCommandStandardVisitor implements AccountCommandVisitor {
    
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException{
        this.standardHandling(addEntryCommand);
    }
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException{
        this.standardHandling(addSubAccountCommand);
    }
    protected abstract void standardHandling(AccountCommand accountCommand) throws PersistenceException;
}
