
package model.visitor;

import persistence.*;

public interface MAccountTypeCommandReturnVisitor<R> {
    
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    
}
