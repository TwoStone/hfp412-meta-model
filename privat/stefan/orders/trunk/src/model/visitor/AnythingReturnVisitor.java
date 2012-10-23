
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,RoleReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleActorManager(PersistentActorManager actorManager) throws PersistenceException;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleActor(PersistentActor actor) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}