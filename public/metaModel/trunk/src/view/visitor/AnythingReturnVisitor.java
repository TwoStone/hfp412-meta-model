
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
