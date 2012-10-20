
package model.visitor;

import persistence.*;

public interface ActorManagerCommandReturnVisitor<R> {
    
    public R handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public R handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException;
    public R handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException;
    
}
