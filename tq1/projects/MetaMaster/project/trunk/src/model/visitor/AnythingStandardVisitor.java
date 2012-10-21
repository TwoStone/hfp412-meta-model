
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
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException{
        this.standardHandling(juristicPerson);
    }
    public void handleOrder(PersistentOrder order) throws PersistenceException{
        this.standardHandling(order);
    }
    public void handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException{
        this.standardHandling(createActorCommand);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException{
        this.standardHandling(naturalPerson);
    }
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException{
        this.standardHandling(supplier);
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
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
