
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,RoleVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleActorManager(PersistentActorManager actorManager) throws PersistenceException;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleActor(PersistentActor actor) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
