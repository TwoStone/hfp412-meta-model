
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleConversionRate(PersistentConversionRate conversionRate) throws PersistenceException;
    public abstract void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public abstract void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException;
    public abstract void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException;
    public abstract void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException;
    public abstract void handleFraction(PersistentFraction fraction) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException;
    public abstract void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    public abstract void handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException;
    
}
