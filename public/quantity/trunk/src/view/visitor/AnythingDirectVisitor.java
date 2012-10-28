
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionRate(ConversionRateView conversionRate) throws ModelException;
    
    public abstract void handleAbsQuantity(AbsQuantityView absQuantity) throws ModelException;
    
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.handleAbsQuantity(quantity);
    }
    public void handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException{
        this.handleAbsQuantity(composedQuantity);
    }
    public abstract void handleAbsUnitType(AbsUnitTypeView absUnitType) throws ModelException;
    
    public void handleTypeReference(TypeReferenceView typeReference) throws ModelException{
        this.handleAbsUnitType(typeReference);
    }
    public void handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException{
        this.handleAbsUnitType(compoundUnitType);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.handleAbsUnitType(unitType);
    }
    public abstract void handleAbsUnit(AbsUnitView absUnit) throws ModelException;
    
    public void handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException{
        this.handleAbsUnit(compoundUnit);
    }
    public void handleUnitReference(UnitReferenceView unitReference) throws ModelException{
        this.handleAbsUnit(unitReference);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleFraction(FractionView fraction) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
