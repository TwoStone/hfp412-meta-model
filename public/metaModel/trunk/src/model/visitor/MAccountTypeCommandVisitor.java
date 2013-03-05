
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddSubAccountTypeCommand;

public interface MAccountTypeCommandVisitor {
    
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    
}
