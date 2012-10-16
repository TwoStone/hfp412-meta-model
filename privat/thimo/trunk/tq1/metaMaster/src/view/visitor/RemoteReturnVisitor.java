
package view.visitor;

import view.*;

public interface RemoteReturnVisitor<R> {
    
    public R handleServer(ServerView server) throws ModelException;
    
}
