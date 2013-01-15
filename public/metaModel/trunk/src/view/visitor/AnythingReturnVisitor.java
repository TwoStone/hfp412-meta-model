
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,MComplexTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,MQuantiObjectTypeReturnVisitor<R> ,MessageOrLinkReturnVisitor<R> ,MAbsOperationReturnVisitor<R> ,MBooleanReturnVisitor<R> {
    
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public R handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    public R handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException;
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public R handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    public R handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    public R handleConversion(ConversionView conversion) throws ModelException;
    public R handleReference(ReferenceView reference) throws ModelException;
    public R handleMeasurement(MeasurementView measurement) throws ModelException;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleMFormalParameter(MFormalParameterView mFormalParameter) throws ModelException;
    public R handleMAssociation(MAssociationView mAssociation) throws ModelException;
    public R handleInstanceObject(InstanceObjectView instanceObject) throws ModelException;
    public R handleFunction(FunctionView function) throws ModelException;
    public R handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    public R handleActualParameter(ActualParameterView actualParameter) throws ModelException;
    public R handleMAspect(MAspectView mAspect) throws ModelException;
    
}
