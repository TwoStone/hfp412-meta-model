
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends CommonDateExceptionVisitor<E>,RoleExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleActorManager(PersistentActorManager actorManager) throws PersistenceException, E;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public void handleActor(PersistentActor actor) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
