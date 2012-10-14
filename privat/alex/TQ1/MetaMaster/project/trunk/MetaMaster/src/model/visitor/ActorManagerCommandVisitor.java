
package model.visitor;

import persistence.*;

public interface ActorManagerCommandVisitor {
    
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    
}
