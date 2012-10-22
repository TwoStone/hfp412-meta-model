
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
