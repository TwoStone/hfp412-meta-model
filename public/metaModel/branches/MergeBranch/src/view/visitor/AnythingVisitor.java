
package view.visitor;

import view.*;

public interface AnythingVisitor extends MComplexTypeVisitor,MBooleanVisitor{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException;
    public void handleMAspect(MAspectView mAspect) throws ModelException;
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException;
    public void handleMBoolean(MBooleanView mBoolean) throws ModelException;
    
}
