
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends RoleExceptionVisitor<E>{
    
    public void handleActorManager(ActorManagerView actorManager) throws ModelException, E;
    public void handleActor(ActorView actor) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
