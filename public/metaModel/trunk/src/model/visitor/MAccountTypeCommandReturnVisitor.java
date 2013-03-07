
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddSubAccountTypeCommand;

public interface MAccountTypeCommandReturnVisitor<R> {
    
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    
}
