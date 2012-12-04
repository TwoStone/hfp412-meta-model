
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends MComplexTypeReturnExceptionVisitor<R, E> ,MBooleanReturnExceptionVisitor<R, E> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    public R handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException, E;
    public R handleMAspect(MAspectView mAspect) throws ModelException, E;
    public R handleMAssociation(MAssociationView mAssociation) throws ModelException, E;
    public R handleMBoolean(MBooleanView mBoolean) throws ModelException, E;
    
}
