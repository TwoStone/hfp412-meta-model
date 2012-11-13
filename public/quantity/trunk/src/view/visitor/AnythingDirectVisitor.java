
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    
    public abstract void handleUnitTypeManager(UnitTypeManagerView unitTypeManager) throws ModelException;
    
    public abstract void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    
    public abstract void handleAbsUnitType(AbsUnitTypeView absUnitType) throws ModelException;
    
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.handleAbsUnitType(unitType);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.handleAbsUnitType(compUnitType);
    }
    public abstract void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    
    public abstract void handleAbsUnit(AbsUnitView absUnit) throws ModelException;
    
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.handleAbsUnit(compUnit);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleAbsQuantity(AbsQuantityView absQuantity) throws ModelException;
    
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.handleAbsQuantity(quantity);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.handleAbsQuantity(compoundQuantity);
    }
    public abstract void handleFractionManager(FractionManagerView fractionManager) throws ModelException;
    
    public abstract void handleReference(ReferenceView reference) throws ModelException;
    
    public abstract void handleConversion(ConversionView conversion) throws ModelException;
    
    
}
