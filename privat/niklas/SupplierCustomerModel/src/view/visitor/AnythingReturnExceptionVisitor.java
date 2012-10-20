
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends RoleReturnExceptionVisitor<R, E> {
    
    public R handleActorManager(ActorManagerView actorManager) throws ModelException, E;
    public R handleProduct(ProductView product) throws ModelException, E;
    public R handleOrder(OrderView order) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleActor(ActorView actor) throws ModelException, E;
    public R handlePosition(PositionView position) throws ModelException, E;
    
}
