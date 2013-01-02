
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException{
        this.standardHandling(conversionManager);
    }
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException{
        this.standardHandling(referenceType);
    }
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException{
        this.standardHandling(quantityManager);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.standardHandling(mFalse);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleAssociationManager(AssociationManagerView associationManager) throws ModelException{
        this.standardHandling(associationManager);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleMAHierarchy(MAHierarchyView mAHierarchy) throws ModelException{
        this.standardHandling(mAHierarchy);
    }
    public void handleMAssociation(MAssociationView mAssociation) throws ModelException{
        this.standardHandling(mAssociation);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.standardHandling(mTrue);
    }
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException{
        this.standardHandling(unitTypeManager);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
    }
    public void handleFunction(FunctionView function) throws ModelException{
        this.standardHandling(function);
    }
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException{
        this.standardHandling(aspectManager);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleMAspect(MAspectView mAspect) throws ModelException{
        this.standardHandling(mAspect);
    }
    public void handleFractionManager(FractionManagerView fractionManager) throws ModelException{
        this.standardHandling(fractionManager);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    public void handleReference(ReferenceView reference) throws ModelException{
        this.standardHandling(reference);
    }
    public void handleConversion(ConversionView conversion) throws ModelException{
        this.standardHandling(conversion);
    }
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
