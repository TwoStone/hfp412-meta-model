
package model.visitor;

import persistence.*;

public abstract class ActorManagerCommandStandardVisitor implements ActorManagerCommandVisitor {
    
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException{
        this.standardHandling(createActorCommand);
    }
    protected abstract void standardHandling(ActorManagerCommand actorManagerCommand) throws PersistenceException;
}