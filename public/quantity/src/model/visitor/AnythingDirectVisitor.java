
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException;
    
    public abstract void handleAbsQuantity(PersistentAbsQuantity absQuantity) throws PersistenceException;
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.handleAbsQuantity(quantity);
    }
    public void handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException{
        this.handleAbsQuantity(composedQuantity);
    }
    public abstract void handleAbsUnitType(PersistentAbsUnitType absUnitType) throws PersistenceException;
    
    public void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException{
        this.handleAbsUnitType(typeReference);
    }
    public void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException{
        this.handleAbsUnitType(compoundUnitType);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.handleAbsUnitType(unitType);
    }
    public abstract void handleAbsUnit(PersistentAbsUnit absUnit) throws PersistenceException;
    
    public void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException{
        this.handleAbsUnit(compoundUnit);
    }
    public void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException{
        this.handleAbsUnit(unitReference);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleFraction(PersistentFraction fraction) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
