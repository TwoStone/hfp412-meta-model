
package view.visitor;

import view.*;

public interface RemoteVisitor {
    
    public void handleServer(ServerView server) throws ModelException;
    
}
