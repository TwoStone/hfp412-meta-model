
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,MComplexTypeReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,MQuantiObjectTypeReturnExceptionVisitor<R, E> ,MessageOrLinkReturnExceptionVisitor<R, E> ,MAbsOperationReturnExceptionVisitor<R, E> ,MBooleanReturnExceptionVisitor<R, E> {
    
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public R handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public R handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException, E;
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException, E;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public R handleConversion(ConversionView conversion) throws ModelException, E;
    public R handleReference(ReferenceView reference) throws ModelException, E;
    public R handleMeasurement(MeasurementView measurement) throws ModelException, E;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleMFormalParameter(MFormalParameterView mFormalParameter) throws ModelException, E;
    public R handleMAssociation(MAssociationView mAssociation) throws ModelException, E;
    public R handleInstanceObject(InstanceObjectView instanceObject) throws ModelException, E;
    public R handleFunction(FunctionView function) throws ModelException, E;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public R handleActualParameter(ActualParameterView actualParameter) throws ModelException, E;
    public R handleMAspect(MAspectView mAspect) throws ModelException, E;
    
}
