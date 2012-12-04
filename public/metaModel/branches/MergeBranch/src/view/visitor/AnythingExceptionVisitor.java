
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>,MBooleanExceptionVisitor<E>{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException, E;
    public void handleMAspect(MAspectView mAspect) throws ModelException, E;
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException, E;
    public void handleMBoolean(MBooleanView mBoolean) throws ModelException, E;
    
}
