
package model.visitor;

import persistence.*;

public interface ActorManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException, E;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public R handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException, E;
    public R handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException, E;
    
}
