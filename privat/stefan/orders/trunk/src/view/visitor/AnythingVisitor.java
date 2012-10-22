
package view.visitor;

import view.*;

public interface AnythingVisitor extends RoleVisitor{
    
    public void handleActorManager(ActorManagerView actorManager) throws ModelException;
    public void handleActor(ActorView actor) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
