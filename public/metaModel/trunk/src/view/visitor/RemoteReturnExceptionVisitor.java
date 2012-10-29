
package view.visitor;
import view.UserException;
import view.*;

public interface RemoteReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleServer(ServerView server) throws ModelException, E;
    
}
