
package model.visitor;

import persistence.*;

public interface ActorManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException, E;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException, E;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public void handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException, E;
    public void handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException, E;
    
}
