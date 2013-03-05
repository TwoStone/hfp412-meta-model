
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddEntryCommand;
import persistence.PersistentAddSubAccountCommand;

public interface AccountCommandVisitor {
    
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException;
    
}
