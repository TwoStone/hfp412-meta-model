
package view.visitor;

import view.*;

public interface AnythingVisitor extends AbsOperationVisitor,QuantifObjectVisitor,MQuantiObjectTypeVisitor,MBooleanVisitor,AbsUnitTypeVisitor,AbsQuantityVisitor,MTypeVisitor,AbsUnitVisitor,MessageOrLinkVisitor{
    
    public void handleServer(ServerView server) throws ModelException;
    public void handleAssociation(AssociationView association) throws ModelException;
    public void handleFormalParameter(FormalParameterView formalParameter) throws ModelException;
    public void handleOperationManager(OperationManagerView operationManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException;
    public void handleInstanceObject(InstanceObjectView instanceObject) throws ModelException;
    public void handleFunction(FunctionView function) throws ModelException;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public void handleMAspect(MAspectView mAspect) throws ModelException;
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    public void handleHierarchy(HierarchyView hierarchy) throws ModelException;
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public void handleMessageManager(MessageManagerView messageManager) throws ModelException;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public void handleConversion(ConversionView conversion) throws ModelException;
    public void handleReference(ReferenceView reference) throws ModelException;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public void handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException;
    public void handleLinkManager(LinkManagerView linkManager) throws ModelException;
    public void handleActualParameter(ActualParameterView actualParameter) throws ModelException;
    
}
