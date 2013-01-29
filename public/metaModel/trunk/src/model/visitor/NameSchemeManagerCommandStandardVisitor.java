
package model.visitor;

import persistence.*;

public abstract class NameSchemeManagerCommandStandardVisitor implements NameSchemeManagerCommandVisitor {
    
    public void handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException{
        this.standardHandling(assignNameSchemeCommand);
    }
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException{
        this.standardHandling(createNameSchemeCommand);
    }
    protected abstract void standardHandling(NameSchemeManagerCommand nameSchemeManagerCommand) throws PersistenceException;
}
