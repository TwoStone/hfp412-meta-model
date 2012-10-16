
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.standardHandling(customer);
    }
    public void handleActorManager(ActorManagerView actorManager) throws ModelException{
        this.standardHandling(actorManager);
    }
    public void handleProduct(ProductView product) throws ModelException{
        this.standardHandling(product);
    }
    public void handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException{
        this.standardHandling(juristicPerson);
    }
    public void handleOrder(OrderView order) throws ModelException{
        this.standardHandling(order);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException{
        this.standardHandling(naturalPerson);
    }
    public void handleSupplier(SupplierView supplier) throws ModelException{
        this.standardHandling(supplier);
    }
    public void handlePosition(PositionView position) throws ModelException{
        this.standardHandling(position);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
