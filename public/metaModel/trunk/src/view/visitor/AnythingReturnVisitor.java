
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbsOperationReturnVisitor<R> ,QuantifObjectReturnVisitor<R> ,MQuantiObjectTypeReturnVisitor<R> ,MBooleanReturnVisitor<R> ,AbsUnitTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,MTypeReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,MessageOrLinkReturnVisitor<R> {
    
    public R handleServer(ServerView server) throws ModelException;
    public R handleFormalParameter(FormalParameterView formalParameter) throws ModelException;
    public R handleOperationManager(OperationManagerView operationManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException;
    public R handleMObject(MObjectView mObject) throws ModelException;
    public R handleInstanceObject(InstanceObjectView instanceObject) throws ModelException;
    public R handleFunction(FunctionView function) throws ModelException;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public R handleMAspect(MAspectView mAspect) throws ModelException;
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public R handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    public R handleHierarchy(HierarchyView hierarchy) throws ModelException;
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public R handleMessageManager(MessageManagerView messageManager) throws ModelException;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public R handleConversion(ConversionView conversion) throws ModelException;
    public R handleReference(ReferenceView reference) throws ModelException;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public R handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException;
    public R handleLinkManager(LinkManagerView linkManager) throws ModelException;
    public R handleActualParameter(ActualParameterView actualParameter) throws ModelException;
    public R handleObjectManager(ObjectManagerView objectManager) throws ModelException;
    
}
