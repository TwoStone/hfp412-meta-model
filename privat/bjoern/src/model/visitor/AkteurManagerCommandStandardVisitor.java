
package model.visitor;

import persistence.*;

public abstract class AkteurManagerCommandStandardVisitor implements AkteurManagerCommandVisitor {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException{
        this.standardHandling(createAkteurCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    protected abstract void standardHandling(AkteurManagerCommand akteurManagerCommand) throws PersistenceException;
}
