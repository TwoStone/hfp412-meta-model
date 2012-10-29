
package model.visitor;

import persistence.*;

public abstract class TypeManagerCommandStandardVisitor implements TypeManagerCommandVisitor {
    
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(addAtomicTypeCommand);
    }
    protected abstract void standardHandling(TypeManagerCommand typeManagerCommand) throws PersistenceException;
}
