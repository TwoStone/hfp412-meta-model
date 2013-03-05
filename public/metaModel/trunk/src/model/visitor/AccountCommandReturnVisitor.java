
package model.visitor;

import persistence.*;

public interface AccountCommandReturnVisitor<R> {
    
    public R handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException;
    public R handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException;
    
}
