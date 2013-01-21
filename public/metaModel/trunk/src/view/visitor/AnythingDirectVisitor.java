
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    
    public abstract void handleAssociation(AssociationView association) throws ModelException;
    
    public abstract void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    
    public abstract void handleFormalParameter(FormalParameterView formalParameter) throws ModelException;
    
    public abstract void handleAbsUnitType(AbsUnitTypeView absUnitType) throws ModelException;
    
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.handleAbsUnitType(unitType);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.handleAbsUnitType(compUnitType);
    }
    public abstract void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    
    public abstract void handleOperationManager(OperationManagerView operationManager) throws ModelException;
    
    public abstract void handleQuantifObject(QuantifObjectView quantifObject) throws ModelException;
    
    public void handleMeasurement(MeasurementView measurement) throws ModelException{
        this.handleQuantifObject(measurement);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.handleQuantifObject(account);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleAssociationManager(AssociationManagerView associationManager) throws ModelException;
    
    public abstract void handleMeasurementTypeManager(MeasurementTypeManagerView measurementTypeManager) throws ModelException;
    
    public abstract void handleAbsQuantity(AbsQuantityView absQuantity) throws ModelException;
    
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.handleAbsQuantity(quantity);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.handleAbsQuantity(compoundQuantity);
    }
    public abstract void handleMQuantiObjectType(MQuantiObjectTypeView mQuantiObjectType) throws ModelException;
    
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException{
        this.handleMQuantiObjectType(mMeasurementType);
    }
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException{
        this.handleMQuantiObjectType(mAccountType);
    }
    public abstract void handleAccountTypeManager(AccountTypeManagerView accountTypeManager) throws ModelException;
    
    public abstract void handleLinkManager(LinkManagerView linkManager) throws ModelException;
    
    public abstract void handleMObject(MObjectView mObject) throws ModelException;
    
    public abstract void handleMessageOrLink(MessageOrLinkView messageOrLink) throws ModelException;
    
    public void handleLink(LinkView link) throws ModelException{
        this.handleMessageOrLink(link);
    }
    public void handleMessage(MessageView message) throws ModelException{
        this.handleMessageOrLink(message);
    }
    public abstract void handleAbsOperation(AbsOperationView absOperation) throws ModelException;
    
    public void handleOperation(OperationView operation) throws ModelException{
        this.handleAbsOperation(operation);
    }
    public abstract void handleInstanceObject(InstanceObjectView instanceObject) throws ModelException;
    
    public abstract void handleHierarchy(HierarchyView hierarchy) throws ModelException;
    
    public abstract void handleMBoolean(MBooleanView mBoolean) throws ModelException;
    
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.handleMBoolean(mFalse);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.handleMBoolean(mTrue);
    }
    public abstract void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    
    public abstract void handleMessageManager(MessageManagerView messageManager) throws ModelException;
    
    public abstract void handleMType(MTypeView mType) throws ModelException;
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.handleMType(mAtomicType);
    }
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.handleMType(mProductType);
    }
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.handleMType(mEmptySumType);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.handleMType(mEmptyProduct);
    }
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException{
        this.handleMType(mAbstractProductType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.handleMType(mSumType);
    }
    public abstract void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    
    public abstract void handleFunction(FunctionView function) throws ModelException;
    
    public abstract void handleAbsUnit(AbsUnitView absUnit) throws ModelException;
    
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.handleAbsUnit(compUnit);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    
    public abstract void handleActualParameter(ActualParameterView actualParameter) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    
    public abstract void handleMAspect(MAspectView mAspect) throws ModelException;
    
    public abstract void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    
    public abstract void handleReference(ReferenceView reference) throws ModelException;
    
    public abstract void handleConversion(ConversionView conversion) throws ModelException;
    
    public abstract void handleObjectManager(ObjectManagerView objectManager) throws ModelException;
    
    
}
