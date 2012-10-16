
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ActorReturnVisitor<R> ,RoleReturnVisitor<R> {
    
    public R handleActorManager(ActorManagerView actorManager) throws ModelException;
    public R handleProduct(ProductView product) throws ModelException;
    public R handleOrder(OrderView order) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleActor(ActorView actor) throws ModelException;
    public R handlePosition(PositionView position) throws ModelException;
    
}
