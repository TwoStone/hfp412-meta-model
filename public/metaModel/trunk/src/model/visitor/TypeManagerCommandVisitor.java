
package model.visitor;

import persistence.*;

public interface TypeManagerCommandVisitor {
    
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    
}