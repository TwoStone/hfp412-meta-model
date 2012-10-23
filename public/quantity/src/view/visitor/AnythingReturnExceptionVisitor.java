
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
