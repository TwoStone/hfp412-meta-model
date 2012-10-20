
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends NamedEntityReturnVisitor<R> ,AbstractMetaTypeReturnVisitor<R> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
