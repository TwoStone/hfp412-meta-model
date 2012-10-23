
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends NamedEntityReturnExceptionVisitor<R, E> ,AbstractMetaTypeReturnExceptionVisitor<R, E> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
