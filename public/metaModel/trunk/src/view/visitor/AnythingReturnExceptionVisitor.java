
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    public R handleMAspect(MAspectView mAspect) throws ModelException, E;
    
}
