
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
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
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException{
        this.standardHandling(booleanTrue);
    }
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
    }
    public void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException{
        this.standardHandling(unitTypeManager);
    }
    public void handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException{
        this.standardHandling(booleanFalse);
    }
    public void handleFunction(FunctionView function) throws ModelException{
        this.standardHandling(function);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
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
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
