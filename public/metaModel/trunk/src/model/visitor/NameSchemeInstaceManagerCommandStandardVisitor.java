
package model.visitor;

import persistence.*;

public abstract class NameSchemeInstaceManagerCommandStandardVisitor implements NameSchemeInstaceManagerCommandVisitor {
    
    public void handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException{
        this.standardHandling(createInstanceCommand);
    }
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException{
        this.standardHandling(assignNameCommand);
    }
    protected abstract void standardHandling(NameSchemeInstaceManagerCommand nameSchemeInstaceManagerCommand) throws PersistenceException;
}
