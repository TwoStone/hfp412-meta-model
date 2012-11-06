
package model.visitor;

import persistence.*;

public interface TypeManagerCommandReturnVisitor<R> {
    
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    
}
