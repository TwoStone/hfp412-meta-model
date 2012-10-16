
package model.visitor;

import persistence.*;

public interface ActorManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    
}
