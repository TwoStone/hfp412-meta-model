
package model.visitor;

import persistence.*;

public abstract class TypeManagerCommandStandardVisitor implements TypeManagerCommandVisitor {
    
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(addAtomicTypeCommand);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.standardHandling(createSubTypeCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.standardHandling(addSubTypeCommand);
    }
    protected abstract void standardHandling(TypeManagerCommand typeManagerCommand) throws PersistenceException;
}
