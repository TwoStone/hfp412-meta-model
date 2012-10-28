
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException{
        this.standardHandling(conversionRate);
    }
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException{
        this.standardHandling(typeReference);
    }
    public void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException{
        this.standardHandling(compoundUnitType);
    }
    public void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException{
        this.standardHandling(compoundUnit);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleFraction(PersistentFraction fraction) throws PersistenceException{
        this.standardHandling(fraction);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException{
        this.standardHandling(unitReference);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException{
        this.standardHandling(composedQuantity);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
