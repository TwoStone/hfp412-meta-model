
package model.visitor;

import persistence.*;

public interface AccountCommandVisitor {
    
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException;
    
}
