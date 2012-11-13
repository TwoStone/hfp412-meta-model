
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public abstract void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public abstract void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public abstract void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public abstract void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    public abstract void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    public abstract void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    public abstract void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    
}
