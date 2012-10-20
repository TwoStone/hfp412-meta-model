
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,RoleReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleActorManager(PersistentActorManager actorManager) throws PersistenceException;
    public R handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleProduct(PersistentProduct product) throws PersistenceException;
    public R handleOrder(PersistentOrder order) throws PersistenceException;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public R handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleActor(PersistentActor actor) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handlePosition(PersistentPosition position) throws PersistenceException;
    public R handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException;
    
}
