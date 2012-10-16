
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
