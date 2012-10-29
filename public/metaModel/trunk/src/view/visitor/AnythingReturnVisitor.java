
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public R handleMAspect(MAspectView mAspect) throws ModelException;
    
}
