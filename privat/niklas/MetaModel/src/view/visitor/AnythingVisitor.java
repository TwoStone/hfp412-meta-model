
package view.visitor;

import view.*;

public interface AnythingVisitor extends NamedEntityVisitor,AbstractMetaTypeVisitor{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
