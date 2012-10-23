
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends NamedEntityExceptionVisitor<E>,AbstractMetaTypeExceptionVisitor<E>{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
