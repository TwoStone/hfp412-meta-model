
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleActorManager(PersistentActorManager actorManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleProduct(PersistentProduct product) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleActor(PersistentActor actor) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException{
        this.handleCommonDate(createProductCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.handleCommonDate(addRoleCommand);
    }
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException{
        this.handleCommonDate(createActorCommand);
    }
    public void handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException{
        this.handleCommonDate(createOrderCommand);
    }
    public void handleAddPositionCommand(PersistentAddPositionCommand addPositionCommand) throws PersistenceException{
        this.handleCommonDate(addPositionCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.handleCommonDate(changeNameCommand);
    }
    public abstract void handleOrder(PersistentOrder order) throws PersistenceException;
    
    public abstract void handleRole(PersistentRole role) throws PersistenceException;
    
    public void handleCustomer(PersistentCustomer customer) throws PersistenceException{
        this.handleRole(customer);
    }
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException{
        this.handleRole(supplier);
    }
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
