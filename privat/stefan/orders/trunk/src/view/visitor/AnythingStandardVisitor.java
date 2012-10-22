
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.standardHandling(customer);
    }
    public void handleActorManager(ActorManagerView actorManager) throws ModelException{
        this.standardHandling(actorManager);
    }
    public void handleSupplier(SupplierView supplier) throws ModelException{
        this.standardHandling(supplier);
    }
    public void handleActor(ActorView actor) throws ModelException{
        this.standardHandling(actor);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
