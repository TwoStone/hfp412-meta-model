
package view.visitor;

import view.*;

public interface AnythingVisitor {
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
