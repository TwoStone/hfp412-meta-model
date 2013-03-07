
package model.visitor;

import persistence.MAccountTypeCommand;
import persistence.PersistenceException;
import persistence.PersistentAddSubAccountTypeCommand;

public abstract class MAccountTypeCommandStandardVisitor implements MAccountTypeCommandVisitor {
    
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException{
        this.standardHandling(addSubAccountTypeCommand);
    }
    protected abstract void standardHandling(MAccountTypeCommand mAccountTypeCommand) throws PersistenceException;
}
