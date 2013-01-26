
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleOperation(OperationView operation) throws ModelException{
        this.standardHandling(operation);
    }
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException{
        this.standardHandling(conversionManager);
    }
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException{
        this.standardHandling(quantityManager);
    }
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException{
        this.standardHandling(associationManager);
    }
    public void handleHierarchy(HierarchyView hierarchy) throws ModelException{
        this.standardHandling(hierarchy);
    }
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException{
        this.standardHandling(mAccountType);
    }
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleMessageManager(MessageManagerView messageManager) throws ModelException{
        this.standardHandling(messageManager);
    }
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException{
        this.standardHandling(unitTypeManager);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
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
    public void handleReference(ReferenceView reference) throws ModelException{
        this.standardHandling(reference);
    }
    public void handleConversion(ConversionView conversion) throws ModelException{
        this.standardHandling(conversion);
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
    public void handleAssociation(AssociationView association) throws ModelException{
        this.standardHandling(association);
    }
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException{
        this.standardHandling(referenceType);
    }
    public void handleFormalParameter(FormalParameterView formalParameter) throws ModelException{
        this.standardHandling(formalParameter);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException{
        this.standardHandling(mEmptyProductType);
    }
    public void handleOperationManager(OperationManagerView operationManager) throws ModelException{
        this.standardHandling(operationManager);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.standardHandling(mFalse);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException{
        this.standardHandling(measurementTypeManager);
    }
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException{
        this.standardHandling(mMeasurementType);
    }
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.standardHandling(mEmptySumType);
    }
    public void handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException{
        this.standardHandling(accountTypeManager);
    }
    public void handleLinkManager(LinkManagerView linkManager) throws ModelException{
        this.standardHandling(linkManager);
    }
    public void handleMObject(MObjectView mObject) throws ModelException{
        this.standardHandling(mObject);
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
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException{
        this.standardHandling(accountManager);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    public void handleObjectManager(ObjectManagerView objectManager) throws ModelException{
        this.standardHandling(objectManager);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
