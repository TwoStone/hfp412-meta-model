
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsOperationReturnExceptionVisitor<R, E> ,QuantifObjectReturnExceptionVisitor<R, E> ,MQuantiObjectTypeReturnExceptionVisitor<R, E> ,MBooleanReturnExceptionVisitor<R, E> ,AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> ,MTypeReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,MessageOrLinkReturnExceptionVisitor<R, E> {
    
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleFormalParameter(FormalParameterView formalParameter) throws ModelException, E;
    public R handleOperationManager(OperationManagerView operationManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException, E;
    public R handleMObject(MObjectView mObject) throws ModelException, E;
    public R handleInstanceObject(InstanceObjectView instanceObject) throws ModelException, E;
    public R handleFunction(FunctionView function) throws ModelException, E;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public R handleMAspect(MAspectView mAspect) throws ModelException, E;
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public R handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public R handleHierarchy(HierarchyView hierarchy) throws ModelException, E;
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleMessageManager(MessageManagerView messageManager) throws ModelException, E;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public R handleConversion(ConversionView conversion) throws ModelException, E;
    public R handleReference(ReferenceView reference) throws ModelException, E;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public R handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException, E;
    public R handleLinkManager(LinkManagerView linkManager) throws ModelException, E;
    public R handleActualParameter(ActualParameterView actualParameter) throws ModelException, E;
    public R handleObjectManager(ObjectManagerView objectManager) throws ModelException, E;
    
}
