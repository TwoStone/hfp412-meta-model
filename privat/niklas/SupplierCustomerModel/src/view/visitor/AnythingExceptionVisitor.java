
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends RoleExceptionVisitor<E>{
    
    public void handleActorManager(ActorManagerView actorManager) throws ModelException, E;
    public void handleProduct(ProductView product) throws ModelException, E;
    public void handleOrder(OrderView order) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleActor(ActorView actor) throws ModelException, E;
    public void handlePosition(PositionView position) throws ModelException, E;
    
}
