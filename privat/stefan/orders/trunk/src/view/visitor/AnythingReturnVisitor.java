
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends RoleReturnVisitor<R> {
    
    public R handleActorManager(ActorManagerView actorManager) throws ModelException;
    public R handleActor(ActorView actor) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
