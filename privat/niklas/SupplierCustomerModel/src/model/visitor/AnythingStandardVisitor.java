
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCustomer(PersistentCustomer customer) throws PersistenceException{
        this.standardHandling(customer);
    }
    public void handleActorManager(PersistentActorManager actorManager) throws PersistenceException{
        this.standardHandling(actorManager);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleCreateProductCommand(PersistentCreateProductCommand createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleOrder(PersistentOrder order) throws PersistenceException{
        this.standardHandling(order);
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
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException{
        this.standardHandling(supplier);
    }
    public void handleActor(PersistentActor actor) throws PersistenceException{
        this.standardHandling(actor);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handlePosition(PersistentPosition position) throws PersistenceException{
        this.standardHandling(position);
    }
    public void handleCreateOrderCommand(PersistentCreateOrderCommand createOrderCommand) throws PersistenceException{
        this.standardHandling(createOrderCommand);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
