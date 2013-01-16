
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,MTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,QuantifObjectExceptionVisitor<E>,MQuantiObjectTypeExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>,MAbsOperationExceptionVisitor<E>,MBooleanExceptionVisitor<E>{
    
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException, E;
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException, E;
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException, E;
    public void handleReference(ReferenceView reference) throws ModelException, E;
    public void handleConversion(ConversionView conversion) throws ModelException, E;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException, E;
    public void handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException, E;
    public void handleMFormalParameter(MFormalParameterView mFormalParameter) throws ModelException, E;
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException, E;
    public void handleInstanceObject(InstanceObjectView instanceObject) throws ModelException, E;
    public void handleFunction(FunctionView function) throws ModelException, E;
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException, E;
    public void handleActualParameter(ActualParameterView actualParameter) throws ModelException, E;
    public void handleMAspect(MAspectView mAspect) throws ModelException, E;
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    
}
