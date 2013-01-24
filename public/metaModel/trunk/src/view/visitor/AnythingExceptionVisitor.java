
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsOperationExceptionVisitor<E>,QuantifObjectExceptionVisitor<E>,MQuantiObjectTypeExceptionVisitor<E>,MBooleanExceptionVisitor<E>,AbsUnitTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,MTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>{
    
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleFormalParameter(FormalParameterView formalParameter) throws ModelException, E;
    public void handleOperationManager(OperationManagerView operationManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException, E;
    public void handleMObject(MObjectView mObject) throws ModelException, E;
    public void handleInstanceObject(InstanceObjectView instanceObject) throws ModelException, E;
    public void handleFunction(FunctionView function) throws ModelException, E;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public void handleMAspect(MAspectView mAspect) throws ModelException, E;
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public void handleHierarchy(HierarchyView hierarchy) throws ModelException, E;
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleMessageManager(MessageManagerView messageManager) throws ModelException, E;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public void handleConversion(ConversionView conversion) throws ModelException, E;
    public void handleReference(ReferenceView reference) throws ModelException, E;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public void handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException, E;
    public void handleLinkManager(LinkManagerView linkManager) throws ModelException, E;
    public void handleActualParameter(ActualParameterView actualParameter) throws ModelException, E;
    public void handleObjectManager(ObjectManagerView objectManager) throws ModelException, E;
    
}
