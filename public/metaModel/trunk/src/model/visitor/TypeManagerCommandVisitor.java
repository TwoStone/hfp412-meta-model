
package model.visitor;

import persistence.*;

public interface TypeManagerCommandVisitor {
    
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    
}
