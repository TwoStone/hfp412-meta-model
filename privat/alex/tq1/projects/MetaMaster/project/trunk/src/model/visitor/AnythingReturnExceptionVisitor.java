
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends ActorReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,RoleReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleActorManager(PersistentActorManager actorManager) throws PersistenceException, E;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public R handleProduct(PersistentProduct product) throws PersistenceException, E;
    public R handleOrder(PersistentOrder order) throws PersistenceException, E;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleOrderItem(PersistentOrderItem orderItem) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
