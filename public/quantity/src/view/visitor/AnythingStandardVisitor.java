
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
