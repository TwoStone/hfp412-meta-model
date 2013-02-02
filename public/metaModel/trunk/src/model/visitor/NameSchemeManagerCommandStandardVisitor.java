
package model.visitor;

import persistence.NameSchemeManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentCreateNameSchemeCommand;

public abstract class NameSchemeManagerCommandStandardVisitor implements NameSchemeManagerCommandVisitor {
    
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException{
        this.standardHandling(createNameSchemeCommand);
    }
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException{
        this.standardHandling(assignNameCommand);
    }
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException{
        this.standardHandling(assignTypeCommand);
    }
    protected abstract void standardHandling(NameSchemeManagerCommand nameSchemeManagerCommand) throws PersistenceException;
}
