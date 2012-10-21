
package view.visitor;

import view.*;

public interface AnythingVisitor extends ActorVisitor,RoleVisitor{
    
    public void handleActorManager(ActorManagerView actorManager) throws ModelException;
    public void handleProduct(ProductView product) throws ModelException;
    public void handleOrder(OrderView order) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handlePosition(PositionView position) throws ModelException;
    
}
