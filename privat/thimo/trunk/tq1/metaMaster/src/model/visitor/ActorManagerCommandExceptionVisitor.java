
package model.visitor;

import persistence.*;

public interface ActorManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    
}
