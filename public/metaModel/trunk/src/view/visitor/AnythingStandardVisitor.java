
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException{
        this.standardHandling(conversionManager);
    }
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException{
        this.standardHandling(quantityManager);
    }
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException{
        this.standardHandling(associationManager);
    }
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException{
        this.standardHandling(mAHierarchy);
    }
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException{
        this.standardHandling(mAccountType);
    }
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException{
        this.standardHandling(mEmptySum);
    }
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException{
        this.standardHandling(unitTypeManager);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException{
        this.standardHandling(fractionManager);
    }
    public void handleConversion(ConversionView conversion) throws ModelException{
        this.standardHandling(conversion);
    }
    public void handleReference(ReferenceView reference) throws ModelException{
        this.standardHandling(reference);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.standardHandling(compUnitType);
    }
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMeasurement(MeasurementView measurement) throws ModelException{
        this.standardHandling(measurement);
    }
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException{
        this.standardHandling(referenceType);
    }
    public void handleMOperation(MOperationView mOperation) throws ModelException{
        this.standardHandling(mOperation);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.standardHandling(mFalse);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException{
        this.standardHandling(mMeasurementType);
    }
    public void handleMFormalParameter(MFormalParameterView mFormalParameter) throws ModelException{
        this.standardHandling(mFormalParameter);
    }
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException{
        this.standardHandling(mAssociation);
    }
    public void handleInstanceObject(InstanceObjectView instanceObject) throws ModelException{
        this.standardHandling(instanceObject);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.standardHandling(mTrue);
    }
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleMessage(MessageView message) throws ModelException{
        this.standardHandling(message);
    }
    public void handleFunction(FunctionView function) throws ModelException{
        this.standardHandling(function);
    }
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException{
        this.standardHandling(aspectManager);
    }
    public void handleActualParameter(ActualParameterView actualParameter) throws ModelException{
        this.standardHandling(actualParameter);
    }
    public void handleLink(LinkView link) throws ModelException{
        this.standardHandling(link);
    }
    public void handleMAspect(MAspectView mAspect) throws ModelException{
        this.standardHandling(mAspect);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
