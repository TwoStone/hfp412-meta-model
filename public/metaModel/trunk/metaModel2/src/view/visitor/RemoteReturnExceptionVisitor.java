
package view.visitor;

import view.*;

public interface RemoteReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleServer(ServerView server) throws ModelException, E;
    
}
