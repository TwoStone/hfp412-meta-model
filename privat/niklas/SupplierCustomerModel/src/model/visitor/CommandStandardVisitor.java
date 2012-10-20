
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException{
        this.standardHandling(createActorCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    public void handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException{
        this.standardHandling(addPositionCommand);
    }
    public void handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException{
        this.standardHandling(createOrderCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
