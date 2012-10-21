
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleActorManager(ActorManagerView actorManager) throws ModelException;
    
    public abstract void handleOrderItem(OrderItemView orderItem) throws ModelException;
    
    public abstract void handleProduct(ProductView product) throws ModelException;
    
    public abstract void handleActor(ActorView actor) throws ModelException;
    
    public void handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException{
        this.handleActor(juristicPerson);
    }
    public void handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException{
        this.handleActor(naturalPerson);
    }
    public abstract void handleOrder(OrderView order) throws ModelException;
    
    public abstract void handleRole(RoleView role) throws ModelException;
    
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.handleRole(customer);
    }
    public void handleSupplier(SupplierView supplier) throws ModelException{
        this.handleRole(supplier);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
