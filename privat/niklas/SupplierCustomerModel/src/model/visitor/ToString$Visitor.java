
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleCustomer(PersistentCustomer customer) throws PersistenceException;
    public abstract void handleActorManager(PersistentActorManager actorManager) throws PersistenceException;
    public abstract void handleProduct(PersistentProduct product) throws PersistenceException;
    public abstract void handleOrder(PersistentOrder order) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleSupplier(PersistentSupplier supplier) throws PersistenceException;
    public abstract void handleActor(PersistentActor actor) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    
}