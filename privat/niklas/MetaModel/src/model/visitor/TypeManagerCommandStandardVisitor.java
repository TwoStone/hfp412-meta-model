
package model.visitor;

import persistence.*;

public abstract class TypeManagerCommandStandardVisitor implements TypeManagerCommandVisitor {
    
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException{
        this.standardHandling(createTypeCommand);
    }
    protected abstract void standardHandling(TypeManagerCommand typeManagerCommand) throws PersistenceException;
}
