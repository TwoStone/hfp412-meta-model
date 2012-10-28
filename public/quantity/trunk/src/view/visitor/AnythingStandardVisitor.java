
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleConversionRate(ConversionRateView conversionRate) throws ModelException{
        this.standardHandling(conversionRate);
    }
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleTypeReference(TypeReferenceView typeReference) throws ModelException{
        this.standardHandling(typeReference);
    }
    public void handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException{
        this.standardHandling(compoundUnitType);
    }
    public void handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException{
        this.standardHandling(compoundUnit);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleFraction(FractionView fraction) throws ModelException{
        this.standardHandling(fraction);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleUnitReference(UnitReferenceView unitReference) throws ModelException{
        this.standardHandling(unitReference);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException{
        this.standardHandling(composedQuantity);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
