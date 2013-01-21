
package model.visitor;

import persistence.*;

public abstract class ObjectManagerCommandStandardVisitor implements ObjectManagerCommandVisitor {
    
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException{
        this.standardHandling(createMObjectCommand);
    }
    protected abstract void standardHandling(ObjectManagerCommand objectManagerCommand) throws PersistenceException;
}
