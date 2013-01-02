
package view.visitor;

import view.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,MComplexTypeVisitor,AbsQuantityVisitor,AbsUnitVisitor,MBooleanVisitor{
    
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException;
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public void handleConversion(ConversionView conversion) throws ModelException;
    public void handleReference(ReferenceView reference) throws ModelException;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException;
    public void handleFunction(FunctionView function) throws ModelException;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public void handleMAspect(MAspectView mAspect) throws ModelException;
    
}
