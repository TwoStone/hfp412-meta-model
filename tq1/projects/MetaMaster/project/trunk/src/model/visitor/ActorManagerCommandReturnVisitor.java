
package model.visitor;

import persistence.*;

public interface ActorManagerCommandReturnVisitor<R> {
    
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    
}
