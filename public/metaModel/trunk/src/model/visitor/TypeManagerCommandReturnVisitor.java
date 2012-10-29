
package model.visitor;

import persistence.*;

public interface TypeManagerCommandReturnVisitor<R> {
    
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    
}
