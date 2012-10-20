
package model.visitor;

import persistence.*;

public interface ActorManagerCommandVisitor {
    
    public void handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException;
    public void handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException;
    
}
