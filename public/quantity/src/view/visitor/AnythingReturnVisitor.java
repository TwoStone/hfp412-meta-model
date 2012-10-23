
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleFraction(FractionView fraction) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
